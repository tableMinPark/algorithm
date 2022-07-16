import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = 1;

        for (int i = 2; i <= N; i++){
            dp[i] = i;
            for (int j = 2; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        bw.write(Integer.toString(dp[N]));
        bw.flush();
        br.close();
        bw.close();
    }
}
/**
 * 처음엔 1^2 로만 이루어져있다고 가정해 dp배열을 초기화한다.
 * 자연수 32를 예로 들었을 때
 * dp[32-1²], dp[32-2²], dp[32-3²], dp[32-4²], dp[32-5²] 중에서 최솟값에 +1을 하면 된다.
 */