import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][3];
        int[][] color = new int[N + 1][3];
        
        for (int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            color[i][0] = Integer.parseInt(st.nextToken());
            color[i][1] = Integer.parseInt(st.nextToken());            
            color[i][2] = Integer.parseInt(st.nextToken());

        }
        for (int i = 1; i <= N; i++){
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + color[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + color[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + color[i][2];
        }
        bw.write(Integer.toString(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]))));
        bw.flush();
        br.close();
        bw.close();
    }
}
