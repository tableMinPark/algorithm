import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2178 {
    static int N;
    static int M;
    static int[][] map;
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
        v = new boolean[N][M];

        for (int i = 0; i < N; i++){
            String t = br.readLine();
            for (int j = 0; j < M; j++){
                map[i][j] = t.charAt(j)-'0';
                v[i][j] = false;
            }
        }

        v[0][0] = true;
        BFS(0, 0);
        bw.write(Integer.toString(map[N-1][M-1]));

        bw.flush();
        br.close();
        bw.close();
    }
    public static void BFS(int y, int x){
        Queue<point2178> q = new LinkedList<>();
        q.add(new point2178(y, x));

        while (!q.isEmpty()){
            point2178 p = q.poll();

            for (int i = 0; i < 4; i++){
                int nextY = p.y + py[i];
                int nextX = p.x + px[i];
                if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) continue;
                if (v[nextY][nextX] || map[nextY][nextX] == 0) continue;

                q.add(new point2178(nextY, nextX));
                map[nextY][nextX] = map[p.y][p.x] + 1;
                v[nextY][nextX] = true;
            }
        }
    }
}
class point2178 {
    int y;
    int x;

    point2178(int y, int x){
        this.y = y;
        this.x = x;
    }
}
