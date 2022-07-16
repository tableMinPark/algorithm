import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i - 2] + dp[i - 2]) % 10007;

        }
        bw.write(Integer.toString(dp[n]));

        bw.flush();
        br.close();
        bw.close();
    }
}
//11726 2 x n 타일링 문제와 비슷하지만 2 x 2을 기준으로하는 경우의 수가 하나 늘어난다. 
//dp[n - 2] 의 경우를 한번 더 더해줘야한다. -> 2 x 1 두 개의 블록과 2 x 2 하나의 블록의 경우의 수 때문에 
//n - 2의 경우의 수를 한번 더 더해줘야한다.