import java.io.*;
import java.util.*;

public class s1984 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int max = 0;
            int min = Integer.MAX_VALUE;
            int sum = 0;

            for (int i = 0; i < 10; i++){
                int n = Integer.parseInt(st.nextToken());
                max = Math.max(max, n);
                min = Math.min(min, n);
                sum += n;
            }
            sum -= max + min;

            sb.append("#").append(t).append(" ").append(String.format("%.0f", ((double)sum / 8))).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}