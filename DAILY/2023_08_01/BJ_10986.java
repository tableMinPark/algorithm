import java.io.*;
import java.util.*;

public class BJ_10986 {
    static int N, M;
    static long[] arr, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());
            arr[i] = arr[i - 1] + now;
        }

        count = new long[M];
        for (int i = 1; i <= N; i++) {
            int next = (int) (arr[i] % M);
            arr[i] = next;
            count[next]++;
        }

        long answer = count[0];
        for (int i = 0; i < M; i++) {
            answer += count[i] * (count[i] - 1) / 2;
        }

        System.out.println(answer);
        br.close();
    }
}
