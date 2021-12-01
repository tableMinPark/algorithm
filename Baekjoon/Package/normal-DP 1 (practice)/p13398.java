import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= n; i++) A[i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[2][n + 1];
        int max = dp[0][1] = dp[1][1] = A[1];
  
        for (int i = 2; i <= n; i++){
            dp[0][i] = Math.max(A[i], dp[0][i - 1] + A[i]);
            dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + A[i]);
            if (Math.max(dp[0][i], dp[1][i]) > max) max = Math.max(dp[0][i], dp[1][i]);
        }

        bw.write(Integer.toString(max));
        bw.flush();
        br.close();
        bw.close();
    }
}
//https://seol-limit.tistory.com/46