import java.util.*;

public class p2_1 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0;i < speeds.length; i++){
            int t = 1;
            if (100 - progresses[i] >= speeds[i]){
                t = (100 - progresses[i]) / speeds[i];
                if ((100 - progresses[i]) % speeds[i] != 0) t++;
            }
            q.add(t);
        }
        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()){
            int f = q.poll();
            int count = 1;
            int qLen = q.size();
            for(int i = 0; i < qLen; i++){
                if (f >= q.peek()) {
                    q.poll();
                    count++;
                }
            }
            ans.add(count);
        }

        answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) answer[i] = ans.get(i);

        return answer;
    }
    public static void main(String[] args) {
        int[] t1_p = {93, 30, 55};
        int[] t1_s = {1, 30, 5};
        
        int[] t2_p = {95, 90, 99, 99, 80, 99};
        int[] t2_s = {1, 1, 1, 1, 1, 1};
        
        int[] t3_p = {20, 99, 93, 30, 55, 10};
        int[] t3_s = {5, 10, 1, 1, 30, 5};

        show(solution(t1_p, t1_s));
        show(solution(t2_p, t2_s));
        show(solution(t3_p, t3_s));
    }
    public static void show(int[] answer){
        for (Integer ans : answer) System.out.print(ans + " ");
        System.out.println();
    }
}

/**
모범답안

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}

#참고사항

성능적으로는 별로지만 시각적으로 람다식을 활용한 코드라 간결하다.
 */