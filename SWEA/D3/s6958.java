import java.io.*;
import java.util.*;

public class s6958 {
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

            int[] sol = new int[N];

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) sol[i] += Integer.parseInt(st.nextToken());
                max = Math.max(max, sol[i]);
            }

            int cnt = 0;
            for (int i = 0; i < N; i++){
                if (max == sol[i]) cnt++;
            }
            sb.append("#").append(t).append(" ").append(cnt).append(" ").append(max).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}