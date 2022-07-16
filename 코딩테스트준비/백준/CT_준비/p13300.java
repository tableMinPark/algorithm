import java.io.*;
import java.util.*;

public class p13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[2][7];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            arr[S][Y]++;
        }

        int ans = 0;
        for (int i = 0; i < 2; i++){
            for (int j = 1; j <= 6; j++){
                if (arr[i][j] == 0) continue;
                ans += arr[i][j] / K;
                if (arr[i][j] % K != 0) ans++;
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.flush();
        bw.close();
    }
}