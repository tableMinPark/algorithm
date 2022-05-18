import java.io.*;
import java.util.*;

public class s2817 {
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

            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;

            for (int i = 1; i < 1 << N; i++){
                int sum = 0;
                for (int b = 0; b < N; b++){
                    if ((i & (1 << b)) != 0){
                        sum += arr[b];
                    }
                }
                if (sum == K) answer++;
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}