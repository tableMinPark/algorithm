import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= i; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dp = new int[n + 1][n + 1];
        int max = dp[1][1] = a[1][1];

        for (int i = 2; i <= n; i++){
            for (int j = 1; j <= i; j++){
                dp[i][j] = Math.max(dp[i - 1][j - 1] + a[i][j], dp[i - 1][j] + a[i][j]);
                if (max < dp[i][j]) max = dp[i][j];
            }
        }
        
        bw.write(Integer.toString(max));
        bw.flush();
        br.close();
        bw.close();
    }
}
/**
 7			                7
10 15			            10 15
18 11 16 15		            18 16 15
20 25 23 20 19 19		    20 25 20 19
24 25 30 27 22 28 25 24	    24 30 27 28 24

0 0 0 0 0 0 0 ...
0 7 0
0 3 8 0
0 8 1 0
0 2 7 4 4
0 4 5 2 6 5
 */