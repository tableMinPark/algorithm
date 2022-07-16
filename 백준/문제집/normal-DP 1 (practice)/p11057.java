import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];

        int mod = 10007;

        for (int i = 0; i <= 9; i++){
            dp[0][i] = 0;
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++){
            for (int j = 0; j <= 9; j++){
                for (int k = 0; k <= j; k ++) {
                    dp[i][j] += dp[i - 1][k];
                }
                dp[i][j] %= mod;
            }
        }
        int sum = 0;
        for (int i = 0; i <= 9; i++) sum += dp[N][i];
        bw.write(Integer.toString(sum %= mod));
        bw.flush();
        br.close();
        bw.close();
    }
}
/**
0 1 2 3 4 5 6 7 8 9

00 01 02 03 04 05 06 07 08 09
11 12 13 14 15 16 17 18 19
22 23 24 25 26 27 28 29
33 34 35 36 37 38 39
44 45 46 47 48 49
55 56 57 58 59
66 67 68 69
77 78 79
89 99
99
 */