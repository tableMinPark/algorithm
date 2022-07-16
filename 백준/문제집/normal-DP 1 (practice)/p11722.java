import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        int max = 0;

        for (int i = 1; i <= N; i++){
            int min = 0;
            for (int j = 1; j < i; j++){
                if (A[i] < A[j]){
                    if (dp[j] > min) min = dp[j];
                }
            }
            dp[i] = min + 1;
            if (dp[i] > max) max = dp[i];
        }

        bw.write(Integer.toString(max));
        bw.flush();
        br.close();
        bw.close();
    }
}
