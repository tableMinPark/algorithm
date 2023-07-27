import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[31];

        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= N; i++){
            dp[i] = dp[i - 2] * 3;
            for (int j = 4; j <= i; j += 2){
                dp[i] += dp[i - j] * 2;
            }
        }
        bw.write(Integer.toString(dp[N]));
        bw.flush();
        br.close();
        bw.close();
    }
}
