import java.util.*;

public class p1_1 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = {};

        List<Integer> ans = new ArrayList<>();
        for (int[] c : commands){
            List<Integer> t = new ArrayList<>();
            for (int i = c[0] - 1; i < c[1]; i++) t.add(array[i]);
            Collections.sort(t);
            ans.add(t.get(c[2]-1));
        }
        answer = ans.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void main(String[] args) {
        int[] t1_a = {1, 5, 2, 6, 3, 7, 4};
        int[][] t1_c = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        show(solution(t1_a, t1_c));
    }

    public static void show(int[] answer){
        for (int ans : answer) System.out.print(ans + " ");
        System.out.println();
    }
}

/*
모범답안

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}

#참고
Arrays.copyOfRange(list, idx_1, idx_2);

인덱스범위로 배열에서 값을 들고온다.

*/