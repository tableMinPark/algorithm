import java.io.*;
import java.util.*;

public class s9229 {
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

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

            int answer = -1;
            for (int i = 0; i < N - 1; i++){
                for (int j = i + 1; j < N; j++){
                    int sum = arr[i] + arr[j];
                    if (sum <= M) answer = Math.max(answer, sum);
                }
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");            
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}