import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c; i++){
            int n = Integer.parseInt(br.readLine());
            for (int j = 4; j <= n; j++){
                if (dp[j] != 0) continue;
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }
            sb.append(dp[n]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
//https://sihyungyou.github.io/baekjoon-9095/