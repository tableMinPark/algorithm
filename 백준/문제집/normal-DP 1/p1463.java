import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1463 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n + 1];
        dp[0] = dp[1] = 0;
        
        bw.write(Integer.toString(recur(n)));
        bw.flush();
        br.close();
        bw.close();
    }
    public static int recur(int n){
        if (dp[n] == null){
            if (n % 6 == 0){
                dp[n] = Math.min(recur(n - 1), Math.min(recur(n / 3), recur(n / 2))) + 1;
            }
            else if (n % 3 == 0){
                dp[n] = Math.min(recur(n / 3), recur(n - 1)) + 1;
            }
            else if (n % 2 == 0){
                dp[n] = Math.min(recur(n / 2), recur(n - 1)) + 1;
            }
            else{
                dp[n] = recur(n - 1) + 1;
            }
        }
        return dp[n];
    }
}
//https://st-lab.tistory.com/133