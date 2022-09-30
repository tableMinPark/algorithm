import java.io.*;

public class p1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int[] dp = new int[X + 1];

        for (int i = 2; i <= X; i++){
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
        }

        System.out.println(dp[X]);
        br.close();
    }
}

// public class p1463 {

//     static int N;
//     static Integer[] dp;

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         N = Integer.parseInt(br.readLine());
//         dp = new Integer[1000_001];

//         dp[0] = dp[1] = 0;

//         recur(N);

//         System.out.println(dp[N]);
//         br.close();
//     }

//     static int recur(int n){
//         if (dp[n] == null){
//             Integer min = Integer.MAX_VALUE;
//             if (n % 3 == 0) min = Math.min(min, recur(n / 3) + 1);
//             if (n % 2 == 0) min = Math.min(min, recur(n / 2) + 1);
//             min = Math.min(min, recur(n - 1) + 1);
//             dp[n] = min;
//         }
//         return dp[n];
//     }
// }