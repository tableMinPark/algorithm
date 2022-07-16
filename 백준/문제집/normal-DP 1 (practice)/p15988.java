import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p15988 {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int mod = 1000000009;
        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 1000001; i++){
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % mod;
        }

        for (int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            sb.append(Long.toString(dp[n])).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
/**
1)
1

2)
1+1
  2

3)
1+1+1
  2+1
  1+2
    3

4)
1+1+1+1
  1+2+1
  2+1+1
    3+1
  1+1+2
    2+2
    1+3
*/