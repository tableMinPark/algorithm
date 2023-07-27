import java.io.*;

public class p9095 {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            n = Integer.parseInt(br.readLine());

            dp = new int[12];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i <= n; i++){
                dp[i] += dp[i - 3];
                dp[i] += dp[i - 2];
                dp[i] += dp[i - 1];
            }

            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb.toString().trim());
        br.close();
    }
}