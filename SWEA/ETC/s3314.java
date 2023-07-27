import java.io.*;
import java.util.*;

public class s3314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int sum = 0;
            for (int i = 0; i < 5; i++){
                int s = Integer.parseInt(st.nextToken());

                if (s < 40) sum += 40;
                else sum += s;
            }

            sb.append("#").append(t).append(" ").append(sum / 5).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}