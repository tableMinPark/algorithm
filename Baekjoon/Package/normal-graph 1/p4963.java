import java.io.*;
import java.util.*;

public class p4963 {
    static int w, h;
    static int[][] map;
    static boolean[][] v;
    static int[] py = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] px = {0, 0, -1, 1, 1, -1, 1, -1};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            map = new int[h][w];
            v = new boolean[h][w];

            for (int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;

            for (int i = 0; i < h; i++){
                for (int j = 0; j < w; j++){
                    if (!v[i][j] && map[i][j] != 0) {
                        DFS(i, j);
                        answer++;
                    }
                }
            }     
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int y, int x){
        v[y][x] = true;
        for (int i = 0; i < 8; i++){
            int nextY = y + py[i];
            int nextX = x + px[i];

            if (nextY < 0 || nextY >= h || nextX < 0 || nextX >= w || v[nextY][nextX]) continue;
            if (map[nextY][nextX] == 0) continue;
            
            DFS(nextY, nextX);
        }
    }
}