import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N + 1];

        for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[2][N + 1];

        for (int i = 1; i <= N; i++){
            int um = 0;
            for (int j = 1; j < i; j++){
                if (A[i] > A[j]){
                    if (dp[0][j] > um) um = dp[0][j];
                }
            }   
            dp[0][i] = um + 1;         
        }

        int max = 0;

        for (int i = N; i >= 1; i--){
            int dm = 0;
            for (int j = N; j > i; j--){
                if (A[i] > A[j]){
                    if (dp[1][j] > dm) dm = dp[1][j];
                }
            }
            dp[1][i] = dm + 1;
            if (dp[1][i] + dp[0][i] - 1 > max) max = dp[1][i] + dp[0][i] - 1;
        }

        bw.write(Integer.toString(max));
        bw.flush();
        br.close();
        bw.close();
    }
}
/**
 * https://st-lab.tistory.com/136
7
9 1 2 3 2 1 9
1 1 2 3 2 1 4 
 */