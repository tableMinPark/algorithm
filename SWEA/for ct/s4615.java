import java.io.*;
import java.util.*;

public class s4615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());     

        StringTokenizer st;

        int[] px = {0, 0, -1, 1, -1, -1, 1, 1};
        int[] py = {-1, 1, 0, 0, -1, 1, -1, 1};
        
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N + 1][N + 1];
            int s = N / 2;
            map[s][s] = 2;
            map[s][s + 1] = 1;
            map[s + 1][s] = 1;
            map[s + 1][s + 1] = 2; 

            for (int r = 0; r < M; r++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[y][x] = c;

                for (int i = 0; i < 8; i++){
                    int nextX = x;
                    int nextY = y;

                    for (int cnt = 0; cnt < N; cnt++){
                        nextX += px[i];
                        nextY += py[i];

                        if (nextX < 1 || nextX > N || nextY < 1 || nextY > N || map[nextY][nextX] == 0) break;

                        if (map[nextY][nextX] == map[y][x]){
                            for (int j = 0; j < cnt; j++){
                                nextX -= px[i];
                                nextY -= py[i];
                                map[nextY][nextX] = map[y][x];
                            }
                            break;
                        }
                    }
                }
            }

            int[] ans = new int[3];

            for (int i = 1; i <= N; i++){
                for (int j = 1; j <= N; j++) ans[map[i][j]]++;
            }
            
            sb.append("#").append(t).append(" ").append(ans[1]).append(" ").append(ans[2]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}