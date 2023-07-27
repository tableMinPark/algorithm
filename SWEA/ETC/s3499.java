import java.io.*;
import java.util.*;

public class s3499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());

            Queue<String> qa = new LinkedList<>();
            Queue<String> qb = new LinkedList<>();

            for (int i = 0; i < N / 2; i++) qa.add(st.nextToken());
            if (N % 2 == 1) qa.add(st.nextToken());           
            for (int i = 0; i < N / 2; i++) qb.add(st.nextToken());
            
            for (int i = 0; i < N / 2; i++) {                
                sb.append(qa.poll()).append(" ");      
                sb.append(qb.poll()).append(" ");
            }            
            if (N % 2 == 1) sb.append(qa.poll()).append(" ");

            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}