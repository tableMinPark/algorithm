import java.io.*;
import java.util.*;

public class p1938 {
    static int N;
    static char[][] map;
    static Queue<P> q;
    static boolean[][][] v;
    static int[] py = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] px = {0, 0, -1, 1, -1, 1, 1, -1};
    static int[][] cy = {{0, 0, 0}, {-1, 1, 0}};
    static int[][] cx = {{-1, 1, 0}, {0, 0, 0}};
    static int answer = Integer.MAX_VALUE;

    public static class P{
        int y;
        int x;
        int d;
        int l;
        public P(int y, int x, int d, int l){
            this.y = y;
            this.x = x;
            this.d = d;
            this.l = l;
        }
    }
    // 0 - 가로
    // 1 - 세로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        q = new LinkedList<>();
        v = new boolean[2][N][N];

        List<P> start = new ArrayList<>();
        List<P> end = new ArrayList<>();

        for (int y = 0; y < N; y++){
            char[] input = br.readLine().toCharArray();
            for (int x = 0; x < N; x++){
                map[y][x] = input[x];
                if (map[y][x] == 'B') {
                    start.add(new P(y, x, 0, 0));
                    map[y][x] = '0';
                }
                if (map[y][x] == 'E') {
                    end.add(new P(y, x, 0, 0));
                    map[y][x] = '0';
                }
            }
        }

        int sy = start.get(1).y, sx = start.get(1).x, sd = start.get(0).y == start.get(1).y ? 0 : 1;
        int ey = end.get(1).y, ex = end.get(1).x, ed = end.get(0).y == end.get(1).y ? 0 : 1;

        BFS(sy, sx, sd, ey, ex, ed);

        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? 0 : answer));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void BFS(int sy, int sx, int sd, int ey, int ex, int ed){
        Queue<P> q = new LinkedList<>();

        q.add(new P(sy, sx, sd, 0));
        v[sd][sy][sx] = true;

        while(!q.isEmpty()){
            P now = q.poll();

            if (now.y == ey && now.x == ex && now.d == ed) answer = Math.min(answer, now.l);

        L:  for (int i = 0; i < 4; i++){
                int nextY = now.y + py[i];
                int nextX = now.x + px[i];
                for (int j = 0; j < 3; j++){
                    int ty = nextY + cy[now.d][j];
                    int tx = nextX + cx[now.d][j];

                    if (ty < 0 || ty >= N || tx < 0 || tx >= N) continue L;
                    if (map[ty][tx] == '1') continue L;
                }

                if (!v[now.d][nextY][nextX]){
                    q.add(new P(nextY, nextX, now.d, now.l + 1));
                    v[now.d][nextY][nextX] = true;
                }
            }

            if (check(now.y, now.x) && !v[ now.d == 1 ? 0 : 1][now.y][now.x]){
                q.add(new P (now.y, now.x, now.d == 1 ? 0 : 1, now.l + 1));
                v[now.d == 1 ? 0 : 1][now.y][now.x] = true;
            }
        }
    }

    public static boolean check(int y, int x){
        for (int i = 0; i < 8; i++){
            int nextY = y + py[i];
            int nextX = x + px[i];
            if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N || map[nextY][nextX] == '1') return false; 
        }
        return true;
    }
}