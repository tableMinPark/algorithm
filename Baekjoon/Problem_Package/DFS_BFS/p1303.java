import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1303 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] v;
    static int[] py = {-1, 1, 0, 0};
    static int[] px = {0, 0, -1, 1};
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for (int i = 0; i < M; i++){
            String t = br.readLine();
            for (int j = 0; j < N; j++){
                map[i][j] = t.charAt(j) == 'W' ? 1 : 0;
            }
        }

        v = new boolean[M][N];
        count = new int[2];

        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if (!v[i][j]) count[map[i][j]] += Math.pow(BFS(i, j, map[i][j]), 2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count[1]).append(" ").append(count[0]);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    public static int BFS(int y, int x, int color){
        Queue<soldier> q = new LinkedList<>();
        q.add(new soldier(y, x));
        v[y][x] = true;
        int subCount = 1;

        while(!q.isEmpty()){
            soldier s = q.poll();

            for (int i = 0; i < 4; i++){
                int nextY = s.y + py[i];
                int nextX = s.x + px[i];

                if (nextY < 0 || nextX < 0 || nextY >= M || nextX >= N) continue;
                if (v[nextY][nextX] || map[nextY][nextX] != color) continue;

                q.add(new soldier(nextY, nextX));
                v[nextY][nextX] = true;
                subCount++;
            }
        }
        return subCount;
    }
}
class soldier{
    int y;
    int x;

    soldier(int y, int x){
        this.y = y;
        this.x = x;
    }
}