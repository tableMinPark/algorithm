import java.util.Stack;

public class p2_4 {
    
    public static int[] solution(int[] prices) {
        int[] answer = {};

        Stack<Integer> s = new Stack<>();
        Stack<Integer> t = new Stack<>();

        answer = new int[prices.length];
        answer[prices.length-1] = 0;
        s.push(prices[prices.length-1]);

        for (int i = prices.length - 2; i >= 0 ; i--){
            int count = 0;
            while(!s.isEmpty()){
                if (s.peek() >= prices[i]) {
                    t.push(s.pop());
                    count++;
                }
                else {
                    count++;
                    break;
                }
            }
            while(!t.isEmpty()) s.push(t.pop());
            answer[i] = count;
            s.push(prices[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] t1 = {1,2,3,2,3};
        int[] t2 = {2,3,1,2,3};

        show(solution(t1));
        show(solution(t2));
    }

    public static void show(int[] answer){
        for (int ans : answer) System.out.print(ans + " ");
        System.out.println();
    }
}
