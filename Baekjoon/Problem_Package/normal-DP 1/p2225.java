import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p2225{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int mod = 1000000000;

        long[][] dp = new long[K + 1][N + 1];
        for (int i = 0; i <= N; i++){
            dp[0][i] = 0;
            dp[1][i] = 1;
        }

        for (int i = 2; i <= K; i++){
            for (int j = 0; j <= N; j++){
                for (int k = 0; k <= j; k++){
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= mod;
                }
            }
        }
        bw.write(Long.toString(dp[K][N]));
        bw.flush();
        br.close();
        bw.close();
    }
}
/**
 * https://hongjw1938.tistory.com/63
 * 
 * N = 5, K = 3이라고 가정한다.
 * 
 * ? + ? + M = 5 다음 식과같이 마지막에 더할 숫자를 M이라고 가정한다.
 * 
 * M이 만약 0이라면 이전 까지의 합이 5이고, 1이면 4, 2이면 3. 3이면 2, 4이면 1, 5이면 0이라는 의미이다. 
 * 
 * a + b + 0 = 5 -> a + b = 5 : 2개를 더했을 때 5가 나오는 경우의 수의 합
 * a + b + 1 = 5 -> a + b = 4 : 2개를 더했을 때 4가 나오는 경우의 수의 합
 * a + b + 2 = 5 -> a + b = 3 : 2개를 더했을 때 3가 나오는 경우의 수의 합
 * a + b + 3 = 5 -> a + b = 2 : 2개를 더했을 때 2가 나오는 경우의 수의 합
 * a + b + 4 = 5 -> a + b = 1 : 2개를 더했을 때 1이 나오는 경우의 수의 합
 * a + b + 5 = 5 -> a + b = 0 : 2개를 더했을 때 0이 나오는 경우의 수의 합
 */