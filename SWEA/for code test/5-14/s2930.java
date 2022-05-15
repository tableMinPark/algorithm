import java.io.*;
import java.util.*;

public class s2930 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

            sb.append("#").append(t).append(" ");
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());

                int K = Integer.parseInt(st.nextToken());

                if (K == 1){
                    int X = Integer.parseInt(st.nextToken());
                    q.add(X);
                } else{
                    if (q.isEmpty()) sb.append("-1 ");
                    else sb.append(q.poll()).append(" ");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}