import java.io.*;
import java.util.*;

public class p2635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        int max = 0;

        StringBuilder sb = new StringBuilder();

        for (int M = N; M >= 0; M--){
            Queue<Integer> q = new LinkedList<>();

            int f = N;
            int s = M;

            q.add(f);
            
            int cnt = 1;

            while(s >= 0){
                q.add(s);
                cnt++;
                int temp = s;
                s = f - s;   
                f = temp;
            }

            if (cnt > max){
                max = cnt;
                sb = new StringBuilder();
                sb.append(cnt).append("\n");
                while(!q.isEmpty()) sb.append(q.poll()).append(" ");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}