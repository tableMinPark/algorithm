import java.util.*;

public class p2_2 {
    public static int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};

        LinkedList<Integer> y = new LinkedList<>();

        for (int i = 1; i <= yellow; i++) if (yellow % i == 0) y.add(yellow / i);
        if (yellow == 1) y.add(1);

        while(!y.isEmpty()){
            int f = y.peekFirst();
            int l = y.peekLast();
            if ((f * 2) + (l * 2) + 4 == brown){
                answer[0] = f + 2;
                answer[1] = l + 2;
                break;
            }
            y.pollFirst();
            if (!y.isEmpty()) y.pollLast();
        }
        

        return answer;
    }
    public static void main(String[] args) {
        show(solution(10, 2));
        show(solution(8, 1));
        show(solution(24, 24));        
    }
    public static void show(int[] answer){
        for (int ans : answer) System.out.print(ans + " ");
        System.out.println();
    }
}
