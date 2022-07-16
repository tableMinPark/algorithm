import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n + 1];

        for (int i = 1; i <= n; i++){
            p[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        dp[1] = p[1];
        if (n > 1) dp[2] = p[1] + p[2];
        for (int i = 3; i <= n; i++){
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + p[i], dp[i - 3] + p[i - 1] + p[i]));
        }

        bw.write(Integer.toString(dp[n]));
        bw.flush();
        br.close();
        bw.close();
    }
}
