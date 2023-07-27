import java.io.*;
import java.util.*;

public class s7964 {
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
            int[] map = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) map[i] = Integer.parseInt(st.nextToken());

            int answer = 0, i = -1;
            
            while(i < N - 1){
                boolean check = false;

                for (int j = 1; j <= D; j++){
                    if (i + j < N && map[i + j] == 1){
                        check = true;
                        i += j;
                        break;
                    }
                }
                if (!check){
                    answer++;
                    i += D;
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}