import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[n];

        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        int max = dp[0] = A[0];

        for (int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i - 1] + A[i], A[i]);   
            if (max < dp[i]) max = dp[i];         
        }
        
        bw.write(Integer.toString(max));
        bw.flush();
        br.close();
        bw.close();
    }
}
