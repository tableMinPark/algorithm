import java.io.*;
import java.util.*;

public class p11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int sum = 0;
        int result = 0;
        for (int i = 1; i <= N; i++){
            sum += arr[i];
            result += sum;
        }

        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }
}