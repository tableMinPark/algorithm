import java.io.*;
import java.util.*;

public class s6730 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

            int up = 0;
            int down = 0;

            for (int i = 1; i < N; i++){
                if (arr[i - 1] < arr[i]) up = Math.max(up, arr[i] - arr[i - 1]);
                if (arr[i - 1] > arr[i]) down = Math.max(down, arr[i - 1] - arr[i]);
            }

            sb.append("#").append(t).append(" ").append(up).append(" ").append(down).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}