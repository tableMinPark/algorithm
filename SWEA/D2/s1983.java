import java.io.*;
import java.util.*;

public class s1983 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Double[] arr = new Double[N];
            Double score = 0.0;

            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                
                int m = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                int h = Integer.parseInt(st.nextToken());

                arr[i] = m * 0.35 + l * 0.45 + h * 0.2;

                if (i + 1 == K) score = arr[i];
            }

            Arrays.sort(arr, Collections.reverseOrder());

            String[] rank = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

            for (int i = 0; i < N; i++){
                if (arr[i] == score){
                    sb.append("#").append(t).append(" ").append(rank[i / (N / 10)]).append("\n");
                }
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}