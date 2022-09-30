import java.io.*;

public class p11727 {

    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[1001];
        arr[1] = 1;
        arr[2] = 3;

        for (int i = 3; i <= N; i++) arr[i] = (arr[i - 1] + arr[i - 2] + arr[i - 2]) % 10_007;

        System.out.println(arr[N]);
        br.close();
    }
}