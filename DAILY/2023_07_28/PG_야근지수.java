import java.util.*;

class PG_야근지수 {
// 정렬을 이용한 풀이 (효율성 X)
//     public long solution(int n, int[] works) {
//         long answer = 0;

//         for (int i = 0; i < n; i++) {
//             Arrays.sort(works);
//             works[works.length - 1]--;
//         }
//         Arrays.sort(works);
//         for (int i = works.length - 1; i >= 0; i--) {
//             if (works[i] <= 0)
//                 break;
//             answer += Math.pow(works[i], 2);
//         }

//         return answer;
//     }

    // 우선순위 큐 사용 (효율성 O)
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>((n1, n2) -> n2 - n1);

        for (int work : works) {
            q.offer(work);
        }

        for (int i = 0; i < n; i++) {
            if (q.isEmpty()) {
                break;
            }
            int next = q.poll() - 1;

            if (next > 0) {
                q.offer(next);
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();
            answer += Math.pow(now, 2);
        }


        return answer;
    }
}