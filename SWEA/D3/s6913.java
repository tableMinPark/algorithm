import java.io.*;
import java.util.*;

public class s6913 {
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

            int[] arr = new int[N];
            int max = 0;

            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++){
                    arr[i] += Integer.parseInt(st.nextToken());
                }
                max = Math.max(max, arr[i]);
            }

            int maxCnt = 0;
            for (int i = 0; i < N; i++){
                if (arr[i] == max) maxCnt++;
            }

            sb.append("#").append(t).append(" ").append(maxCnt).append(" ").append(max).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}