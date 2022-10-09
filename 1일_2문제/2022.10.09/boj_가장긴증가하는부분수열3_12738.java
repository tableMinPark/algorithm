import java.io.*;
import java.util.*;

public class boj_가장긴증가하는부분수열3_12738 {

    static int N;
    static int[] A, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        int len = 0;
        for (int i = 0; i < N; i++){
            int position = Arrays.binarySearch(dp, 0, len, A[i]);       // 0 ~ (len - 1) 까지의 인덱스만큼 탐색하여 A[i] 를 찾음
            if (position >= 0) continue;        // 이미 수가 존재하면 패스
            position = Math.abs(position) - 1;  // 존재하지 않으면 가야할 자리에 인덱스가 나옴 -1, -2, -3, -4 순으로
            dp[position] = A[i];
            if (len == position) len++;
        }

        System.out.println(len);
        br.close();
    }
}