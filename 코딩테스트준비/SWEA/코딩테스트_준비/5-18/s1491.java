import java.io.*;
import java.util.*;

public class s1491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            
            long N = Long.parseLong(st.nextToken());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            long answer = Integer.MAX_VALUE;
            for (int R = 1; R <= N; R++){
                int C = 1;
                while(R * C <= N){                  
                    long ans = A * Math.abs(R - C);
                    ans += B * (N - R * C);
                    answer = Math.min(answer, ans);
                    C++;
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