import java.util.*;

public class p2_2 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<print> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) q.add(new print(priorities[i], i));

        while (!q.isEmpty()){
            print max = q.poll();
            q.add(max);
            for (int i = 0; i < q.size() - 1; i++){
                print temp = q.poll();
                if (max.pri >= temp.pri){
                    q.add(temp);
                }
                else{
                    max = temp;
                    break;
                }
            }
            answer++;
            if (max.idx == q.peek().idx) q.poll();
            if (max.idx == location) break;
        }
        
        return answer;
    }
    //정답
    public static int solution_2(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) q.add(i);

        while (!q.isEmpty()){
            Iterator<Integer> iter = q.iterator();
            int max = q.peek();
            while (iter.hasNext()) {
                int t = iter.next();
                if (priorities[max] < priorities[t]) max = t;
            }
            for (int i = 0; i < q.size(); i++){
                int t = q.poll();
                if (t == max) break;
                q.add(t);
            }
            answer++;
            if (max == location) break;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] t1_p = {2, 1, 3, 2};
        int t1_l = 2;
        
        int[] t2_p = {1, 1, 9, 1, 1, 1};
        int t2_l = 0;

        int[] t3_p = {3, 3, 4, 2};
        int t3_l = 3;

        System.out.println(solution(t1_p, t1_l));
        System.out.println(solution(t2_p, t2_l));
        System.out.println(solution(t3_p, t3_l));

        System.out.println(solution_2(t1_p, t1_l));
        System.out.println(solution_2(t2_p, t2_l));
        System.out.println(solution_2(t3_p, t3_l));
    }
}

class print{
    int pri;
    int idx;

    print(int pri, int idx){
        this.pri = pri;
        this.idx = idx;
    }
}

/**
모범답안

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;



        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }

        return answer;
    }
}

#참고

priorities 배열을 미리 내림차순으로 정리하여 배열뒤부터 참고하여 작은 값부터 참고한다.
location값을 줄여가면서 큐 연산을 한다.

 */