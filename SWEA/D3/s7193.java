import java.io.*;
import java.util.*;

public class s7193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            char[] X = st.nextToken().toCharArray();

            long sum = 0;
            long pow = 1;
            for (int i = X.length - 1; i >= 0; i--){
                int n = X[i]-'0';
                sum += (n * pow) % (N - 1);
            }
            sb.append("#").append(t).append(" ").append(sum % (N - 1)).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}