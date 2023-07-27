import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[2][n + 1];

            for (int i = 0; i < 2; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) dp[i][j] = Integer.parseInt(st.nextToken());
            }

            dp[0][0] = dp[1][0] = 0;

            for (int i = 2; i <= n; i++){
                dp[0][i] += Math.max(dp[1][i - 1], dp[1][i - 2]);
                dp[1][i] += Math.max(dp[0][i - 1], dp[0][i - 2]);
            }
            sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
//https://sihyungyou.github.io/baekjoon-9465/
//을 공유하는 현재 스티커를 고른다면 위 혹은 밑, 양옆의 스티커는 포기해야한다. 
//그래서 점화식은 이전 대각선과 전전 대각선의 값을 현재값과 각각 더해 비교하여 max값을 취하는 방식으로 계산한다.