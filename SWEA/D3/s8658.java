import java.io.*;
import java.util.*;

public class s8658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++){
                int sum = 0;

                char[] str = st.nextToken().toCharArray();
                for (char s : str) sum += s-'0';
                
                max = Math.max(max, sum);
                min = Math.min(min, sum);
            }
            sb.append("#").append(t).append(" ").append(max).append(" ").append(min).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}