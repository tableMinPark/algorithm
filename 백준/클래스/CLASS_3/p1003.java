import java.io.*;

public class p1003 {

    static int T, N;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());

            dp = new Integer[41][2];
            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;
            fibo(N);
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }

        System.out.println(sb.toString().trim());
        br.close();
    }

    static Integer[] fibo(int n){
        if (dp[n][0] == null || dp[n][1] == null){
            Integer[] N_1 = fibo(n - 1);
            Integer[] N_2 = fibo(n - 2);
            dp[n][0] = N_1[0] + N_2[0];
            dp[n][1] = N_1[1] + N_2[1];
        }
        return dp[n];
    }
}