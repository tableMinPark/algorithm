import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p16194 {
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
        dp[1] = p[1];

        for (int i = 1; i <= n; i++){
            dp[i] = p[i];
            for (int j = 1; j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j] + p[j]);
            }
        }

        bw.write(Integer.toString(dp[n]));
        bw.flush();
        br.close();
        bw.close();
    }
}