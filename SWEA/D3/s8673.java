import java.io.*;
import java.util.*;

public class s8673 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int K = Integer.parseInt(br.readLine());

            Queue<Integer> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < (int) Math.pow(2, K); i++){
                q.add(Integer.parseInt(st.nextToken()));
            }

            int answer = 0;
            while(q.size() != 1){
                int A = q.poll();
                int B = q.poll();

                q.add(A > B ? A : B);
                answer += A > B ? A - B : B - A;
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}