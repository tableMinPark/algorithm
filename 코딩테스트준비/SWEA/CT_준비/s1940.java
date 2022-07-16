import java.io.*;
import java.util.*;

public class s1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int answer = 0;
            int V = 0;

            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());

                int C = Integer.parseInt(st.nextToken());
                
                if (C == 1 || C == 2){
                    int iv = Integer.parseInt(st.nextToken());                    
                    V += (C == 1 ? iv : -iv);
                    if (V < 0) V = 0;
                }
                answer += V;
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}