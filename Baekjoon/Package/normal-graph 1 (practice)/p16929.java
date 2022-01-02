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
                if (DFS(i, j, i, j, map[i][j], 1)) {
                    isCycle = true;
                    break Loop;
                }
            }
        }

        bw.write(isCycle ? "YES" : "NO");
        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean DFS(int y, int x, int sy, int sx, int color, int depth){        
        v[y][x] = true;
        for (int i = 0; i < 4; i++){
            int nextY = y + py[i];
            int nextX = x + px[i];

            if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M || map[nextY][nextX] != color) continue;

            if (!v[nextY][nextX]){
                if (DFS(nextY, nextX, sy, sx, color, depth + 1)) return true;
            }
            else{
                if (nextY == sy && nextY == sx && depth > 3)  return true;
            }
        }
        return false;
    }
}