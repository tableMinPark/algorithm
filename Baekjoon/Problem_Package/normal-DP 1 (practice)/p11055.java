import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N + 1];
        for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];

        int max = 0;

        for (int i = 1; i <= N; i++){
            dp[i] = A[i];
            for (int j = 1; j < i; j++){
                if (A[i] > A[j]){
                    if (dp[i] < dp[j] + A[i]) dp[i] = dp[j] + A[i];
                }
            }
            if (dp[i] > max) max = dp[i];
        }

        bw.write(Integer.toString(max));
        bw.flush();
        br.close();
        bw.close();
    }
}
//https://yabmoons.tistory.com/87
/**
 * dp[i] -> i까지의 연속된 숫자의 합 중 가장 큰 수
 */