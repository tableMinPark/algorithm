import java.io.*;

public class p9461 {

    static int T, N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){            
            N = Integer.parseInt(br.readLine());
            arr = new long[101];            
            arr[1] = 1;
            arr[2] = 1;
            arr[3] = 1;

            for (int i = 4; i <= N; i++) arr[i] = arr[i - 3] + arr[i - 2];

            sb.append(arr[N]).append("\n");
        }

        System.out.println(sb.toString().trim());
        br.close();
    }
}