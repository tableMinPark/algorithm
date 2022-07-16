import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        int mod = 9901;

        for (int i = 2; i <= n; i++){
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
        }

        bw.write(Long.toString((dp[n][0] + dp[n][1] + dp[n][2]) % mod));
        bw.flush();
        br.close();
        bw.close();
    }
}
/**
 * https://sihyungyou.github.io/baekjoon-1309/
 ㅁㅁ
 ㅁㅁ
 ㅁㅁ

 1) (ㅁ) (ㅁ) (ㅁㅁ) 1 / 1 / 1
 
 2 - 1) [없을 경우] 없기 떄문에 위 1)의 경우를 다 더함 
 2 - 2) [왼쪽에 있을경우] 왼쪽에 있기 때문에 위 1)경우중 왼쪽에 있는 경우를 제외하고 오른쪽, 없을경우를 다 더함
 2 - 3) [오른쪽에 있을경우] 오른쪽에 있기 때문에 위 1)경우중 오른쪽에 있는 경우를 제외하고 왼쪽, 없을경우를 다 더함
  
 */