import java.io.*;
import java.util.*;

public class p1012 {

    static int T, N, M, K, answer;
    static int[][] map;
    static boolean[][] v;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static class P{
        int y;
        int x;
        public P(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            v = new boolean[N][M];

            for (int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[Y][X] = 1;
            }

            answer = 0;
            for (int y = 0; y < N; y++){
                for (int x = 0; x < M; x++){
                    if (map[y][x] == 0) continue;
                    if (v[y][x]) continue;
                    bfs(y, x);
                    answer++;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString().trim());
        br.close();
    }

    static void bfs(int y, int x){
        Queue<P> q = new ArrayDeque<>();
        q.offer(new P(y, x));
        v[y][x] = true;

        while(!q.isEmpty()){
            P now = q.poll();

            for (int i = 0; i < 4; i++){
                int nextY = now.y + dy[i];
                int nextX = now.x + dx[i];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) continue;
                if (v[nextY][nextX]) continue;
                if (map[nextY][nextX] == 0) continue;

                q.add(new P(nextY, nextX));
                v[nextY][nextX] = true;
            }
        }
    }
}