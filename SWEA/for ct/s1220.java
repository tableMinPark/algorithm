import java.io.*;
import java.util.*;

public class s1220 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++){   
            int N = Integer.parseInt(br.readLine());
        
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for (int i = 0; i < N; i++){
                boolean n = false;

                for (int j = 0; j < N; j++){
                    if (map[j][i] == 1) n = true;
                    if (map[j][i] == 2 && n){
                        n = false;
                        cnt++;
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}