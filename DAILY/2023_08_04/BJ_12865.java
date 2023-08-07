import java.io.*;
import java.util.StringTokenizer;

public class BJ_12865 {
    static int N, K;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][2];
        for (int item = 1; item <= N; item++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            arr[item][0] = W;
            arr[item][1] = V;
        }
        dp = new int[N + 1][K + 1];
        for (int item = 1; item <= N; item++) {
            for (int weight = 1; weight <= K; weight++) {
                int W = weight - arr[item][0];
                int V = arr[item][1];
                if (W < 0) {
                    dp[item][weight] = dp[item - 1][weight];
                } else {
                    dp[item][weight] = Math.max(dp[item - 1][weight], V + dp[item - 1][W]);
                }
            }
        }

        System.out.println(dp[N][K]);
        br.close();
    }
}
