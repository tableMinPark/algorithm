import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[101][10];
        int mod = 1000000000;

        for (int i = 1; i <= 9; i++){
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++){
            for (int j = 0; j <= 9; j++){
                if (j == 0){
                    dp[i][j] = dp[i - 1][j + 1] % mod;
                }
                else if (j == 9){
                    dp[i][j] = dp[i - 1][j - 1] % mod;
                }
                else{
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }

        long c = 0;

        for (int i = 0; i <= 9; i++){
            c += dp[N][i];
        }

        bw.write(Long.toString(c % mod));
        bw.flush();
        br.close();
        bw.close();
    }
}
//https://mygumi.tistory.com/260
//int로는 표현불가능 long형식으로 표현해야한다.