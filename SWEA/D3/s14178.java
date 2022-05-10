import java.io.*;
import java.util.*;

public class s14178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            double div = 2 * D + 1;
            double answer = Math.ceil((double)N / div);

            sb.append("#").append(t).append(" ").append((int)answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}