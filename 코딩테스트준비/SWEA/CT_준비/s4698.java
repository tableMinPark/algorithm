import java.io.*;
import java.util.*;

public class s4698 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        boolean[] v = new boolean[1000001];
        v[1] = true;
        for (int i = 2; i <= 1000000; i++){
            if (v[i]) continue;
            for (int j = i * 2; j <= 1000000; j += i) v[j] = true;
        }

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int D = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int answer = 0;

            for (int i = A; i <= B; i++){
                if (v[i]) continue;
                char[] n = String.valueOf(i).toCharArray();
                
                for (char c : n){
                    if (c-'0' == D) {
                        answer++;
                        break;
                    }
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