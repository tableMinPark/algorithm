import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1940 {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0, end = N - 1, sum = 0, count = 0;
        while(start < end) {
            sum = arr[start] + arr[end];
            if (sum == M) {
                start++;
                end--;
                count++;
            } else if (sum > M) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(count);

        br.close();
    }
}
