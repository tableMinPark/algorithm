import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        bw.write(Integer.toString(dp[n]));
        bw.flush();
        br.close();
        bw.close();
    }
}
//https://assb.tistory.com/entry/%EB%B0%B1%EC%A4%80-11726%EB%B2%88-2xn-%ED%83%80%EC%9D%BC%EB%A7%81
