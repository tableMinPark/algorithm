import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[i], dp[i - j] + p[j]);
            }
        }
        bw.write(Integer.toString(dp[n]));
        bw.flush();
        br.close();
        bw.close();
    }
}
//https://kgh940525.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%B9%B4%EB%93%9C%EA%B5%AC%EB%A7%A4%ED%95%98%EA%B8%B0-11052-DP-%EC%B5%9C%EB%8C%93%EA%B0%92