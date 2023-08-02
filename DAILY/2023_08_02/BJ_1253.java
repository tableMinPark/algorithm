import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1253 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (twoPointer(i)) {
                count++;
            }
        }

        System.out.println(count);
        br.close();
    }

    static boolean twoPointer(int idx) {
        int start = 0, end = N - 1, M = arr[idx];

        while(true) {
            end = end == idx ? end - 1 : end;
            start = start == idx ? start + 1 : start;

            if (start >= end) {
                break;
            }

            int sum = arr[start] + arr[end];
            if (sum == M) {
                System.out.println(start + " " + end);
                return true;
            } else if (sum > M) {
                end--;
            } else {
                start++;
            }
        }

        return false;
    }
}
