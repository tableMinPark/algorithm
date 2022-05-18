import java.io.*;
import java.util.*;

public class s1217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++){
            int T = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append("#").append(T).append(" ").append(pow(N, M, 0, 1)).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
    public static int pow(int n, int m, int d, int ans){
        if (m == d) return ans;
        return pow(n, m, d + 1, ans * n);
    }
}