import java.util.*;

public class p2_1 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Long> h = new PriorityQueue<>();

        for (int s : scoville) h.add((long) s);

        while (h.peek() < K){
            h.add(h.poll() + h.poll() * 2);
            answer++;
            if (h.size() == 1) {
                if (h.poll() < K) answer = -1;                
                break;
            }
        }    
        return answer;
    }

    public static void main(String[] args) {
        int[] t1 = {1,2,3,9,10,12};
        int[] t2 = {0, 1, 2, 3, 4};

        System.out.println(solution(t1, 7));
        System.out.println(solution(t2, 5));
    }
}

/**
모범답안

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++)
            q.add(scoville[i]);

        int count = 0;
        while(q.size() > 1 && q.peek() < K){
            int weakHot = q.poll();
            int secondWeakHot = q.poll();

            int mixHot = weakHot + (secondWeakHot * 2);
            q.add(mixHot);
            count++;
        }

        if(q.size() <= 1 && q.peek() < K)
            count = -1;

        return count;
    }
}

#참고
while문을 좀 더 깔끔하게 작성했다. 

힙문제는 PriorityQueue를 사용하여 풀어야지 효율성을 통과할 가능성이 높다.

힙에 대해서 참고한 블로그
https://velog.io/@gillog/Java-Priority-Queue%EC%9A%B0%EC%84%A0-%EC%88%9C%EC%9C%84-%ED%81%90
 */