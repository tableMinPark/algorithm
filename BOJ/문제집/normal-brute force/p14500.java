import java.io.*;
import java.util.*;

public class p14500 {
    static int N, M;
    static int[][] map;
    static int answer = 0;

    static int[] py = {-1, 1, 0, 0};
    static int[] px = {0, 0, -1, 1};

    static boolean[][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new boolean[N][M];
        
        for (int y = 0; y < N; y++){
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) map[y][x] = Integer.parseInt(st.nextToken());
        }
        for (int y = 0; y < N; y++){
            for (int x = 0; x < M; x++){
                DFS(y, x, 0, 0);
                FuckShape(y, x);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }
    public static void DFS(int y, int x, int depth, int sum){
        if (depth == 4){
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++){
            int nextY = y + py[i];
            int nextX = x + px[i];

            if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) continue;
            if (v[nextY][nextX]) continue;

            v[nextY][nextX] = true;
            DFS(nextY, nextX, depth + 1, sum + map[nextY][nextX]);
            v[nextY][nextX] = false;
        }
    }

    public static void FuckShape(int y, int x){
        int wing = 0;
        int min = Integer.MAX_VALUE;
        int sum = map[y][x];

        for (int i = 0; i < 4; i++){
            int nextY = y + py[i];
            int nextX = x + px[i];
            
            if (wing >= 2) return;

            if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
                wing++;
                continue;
            }
            min = Math.min(min, map[nextY][nextX]);
            sum += map[nextY][nextX];
        }

        if (wing == 0) sum = sum - min;
        answer = Math.max(answer, sum);
    }
}