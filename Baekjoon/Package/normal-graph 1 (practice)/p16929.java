import java.io.*;
import java.util.*;

public class p16929 {
    static int N, M;
    static char[][] map;
    static boolean[][] v;

    static int[] py = {-1, 1, 0, 0};
    static int[] px = {0, 0, -1, 1};

    static boolean isCycle = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        Loop:
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                v = new boolean[N][M];
                DFS(i, j, i, j, map[i][j], 1);
                if (isCycle) break Loop;
            }
        }

        bw.write(isCycle ? "Yes" : "No");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int y, int x, int sy, int sx, int color, int depth){
        v[y][x] = true;
        for (int i = 0; i < 4; i++){
            int nextY = y + py[i];
            int nextX = x + px[i];

            if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M || map[nextY][nextX] != color) continue;
                        
            if (nextY == sy && nextX == sx && depth > 3) isCycle = true;
            
            if (v[nextY][nextX]) continue;
            DFS(nextY, nextX, sy, sx, color, depth + 1);                
        }
    }
}