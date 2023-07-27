// 그리디

import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {-1};

        if (n < s) {
            answer = new int[n];
            Arrays.fill(answer, (int) s / n);

            for (int i = 0; i < s % n; i++){
                answer[i]++;
            }
        }

        Arrays.sort(answer);

        return answer;
    }
}