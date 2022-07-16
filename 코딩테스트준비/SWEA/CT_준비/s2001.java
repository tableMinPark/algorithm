import java.io.*;
import java.util.*;

public class s2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 1; t <= T; t++){
            int answer = 0;

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }
            
            for (int i = 0; i <= N - M; i++){
                for (int j = 0; j <= N - M; j++){
                    int sum = 0;
                    for (int k = 0; k < M; k++){
                        for (int l = 0; l < M; l++) sum += map[i + k][j + l];
                    }
                    answer = Math.max(answer, sum);
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