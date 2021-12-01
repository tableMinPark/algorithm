import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p2573_DFS {
    static int N;
    static int M;
    static int[][] map;
    static int[][] c;
    static boolean[][] v;
    static int[] py = {-1, 1, 0, 0};
    static int[] px = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        c = new int[N][M];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int year = 0;
        int check;

        while (true){
            v = new boolean[N][M];
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if (map[i][j] != 0) MELT(i, j);
                }
            }
            year++;
            check = check_DFS();
            if (check > 1 || check == 0) break;

            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if (map[i][j] != 0) map[i][j] = c[i][j];
                }
            }
        }
        if (check == 0) year = 0;
        
        bw.write(Integer.toString(year));
        bw.flush();
        br.close();
        bw.close();
    }
    public static void MELT(int y, int x){
        int zeroCount = 0;

        for (int k = 0; k < 4; k++){
            int nextY = y + py[k];
            int nextX = x + px[k];

            if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) continue;
            if (map[nextY][nextX] != 0) continue;
            zeroCount++;
        }
        c[y][x] = map[y][x] - zeroCount < 0 ? 0 : map[y][x] - zeroCount;
    }

    public static int check_DFS(){        
        v = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (!v[i][j] && c[i][j] != 0) {
                    DFS(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void DFS(int y, int x){
        v[y][x] = true;
        for (int i = 0; i < 4; i++){
            int nextY = y + py[i];
            int nextX = x + px[i];
            if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) continue;
            if (v[nextY][nextX] || c[nextY][nextX] == 0) continue;
            DFS(nextY, nextX);
        }
    }
}