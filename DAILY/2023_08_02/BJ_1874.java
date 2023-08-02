import java.io.*;
import java.util.*;

// 한번 더 보기
public class BJ_1874 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        int num = 1;
        for (int i = 0; i < N; i++){
            int now = Integer.parseInt(br.readLine());
            if (now >= num) {
                while(now >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int pop = stack.pop();

                if (pop > now) {
                    sb = new StringBuilder();
                    sb.append("NO\n");
                    break;
                }

                sb.append("-\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
