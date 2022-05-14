import java.io.*;
import java.util.*;

public class s1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            String answer = "";

            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                char ch = st.nextToken().toCharArray()[0];
                int cnt = Integer.parseInt(st.nextToken());
                for (int j = 0; j < cnt; j++) answer += ch;
            }

            char[] arr = answer.toCharArray();

            sb.append("#").append(t);
            for (int i = 0; i < arr.length; i++){
                if (i % 10 == 0) sb.append("\n");
                sb.append(arr[i]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}