import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class p14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int max = 0;

        for (int i = 0; i < N; i++){
            int min = 0;
            for (int j = 0; j < i; j++){
                if (A[i] > A[j]){
                    if (min < dp[j]){
                        min = dp[j];
                    }
                }
            }
            dp[i] = min + 1;
            if (max <= dp[i]) max = dp[i];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");

        Stack<Integer> s = new Stack<>();

        for (int i = N - 1; i >= 0; i--){
            if (max == dp[i]){
                s.push(A[i]);
                max--;
            }
        }

        while (!s.isEmpty()) sb.append(s.pop()).append(" ");
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
