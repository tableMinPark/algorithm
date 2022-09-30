import java.io.*;

// https://bada744.tistory.com/m/91 -> 왜 N - 3 -> N - 1 -> N , N - 2 -> N 인가? 
//                                      왜 N - 3 -> N - 2 -> N 는 안되는가?
public class p2579 {

    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[301];
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());

        dp = new int[301];
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);

        for (int i = 4; i <= N; i++){
            dp[i] = Math.max(dp[i], dp[i - 3] + arr[i - 1]);
            dp[i] = Math.max(dp[i], dp[i - 2]);
            dp[i] += arr[i];
        }

        System.out.println(dp[N]);
        br.close();
    }
}