import java.io.*;
import java.util.*;

// JAVA 제출이 없어서 채점불가
public class s1285 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int cnt = 1;
            int min = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int n = Math.abs(Integer.parseInt(st.nextToken()));
                
                if (min == n) cnt++;
                else {
                    cnt = 1;
                    min = Math.min(min, n);
                }
            }            
            sb.append("#").append(t).append(" ").append(min).append(" ").append(cnt).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}