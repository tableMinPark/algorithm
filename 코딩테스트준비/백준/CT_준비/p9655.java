import java.io.*;

public class p9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++){
            dp[i] = Math.min(dp[i - 1] + 1, dp[i - 3] + 1);
        }

        String answer = "";

        if (dp[N] % 2 == 1){
            answer = "SK";
        } else{
            answer = "CY";
        }
        
        bw.write(answer);
        br.close();
        bw.flush();
        bw.close();
    }
}