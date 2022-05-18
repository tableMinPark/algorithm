import java.io.*;
import java.util.*;

public class s7102 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arr = new int[N + M + 1];

            for (int i = 1; i <= N; i++){
                for (int j = 1; j <= M; j++){
                    arr[i + j]++;
                }
            }

            int max = 0;
            for (int i = 2; i <= N + M; i++) max = Math.max(max, arr[i]);

            sb.append("#").append(t);

            for (int i = 2; i <= N + M; i++){
                if (arr[i] == max) sb.append(" ").append(i);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}