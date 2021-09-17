import java.util.*;

public class p2_2 {
    public static int solution(int[] citations) {
        int answer = 0;
        Integer[] cita = Arrays.stream(citations).boxed().toArray(Integer[]::new);

        Arrays.sort(cita, Collections.reverseOrder());

        for (int i = 1; i <= cita.length; i++){
            if (cita[i-1] >= i) answer = i;
        }        
        return answer;
    }

    public static void main(String[] args) {
        int[] t1 = {3, 0, 6, 1, 5};
        int[] t2 = {3, 1, 1, 1, 4};
        int[] t3 = {0, 0, 0, 0, 0, 0, 0};
        int[] t4 = {0, 0, 0, 1};
        int[] t5 = {9, 9, 9, 12};
        int[] t6 = {1, 1, 5, 7, 6};

        System.out.println(solution(t1));
        System.out.println(solution(t2));
        System.out.println(solution(t3));
        System.out.println(solution(t4));
        System.out.println(solution(t5));
        System.out.println(solution(t6));
    }
}

/**
모범답안

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }
}
 */