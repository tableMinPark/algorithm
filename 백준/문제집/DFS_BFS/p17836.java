import java.io.*;
import java.util.*;

public class p17836 {
    static int N, M, T;
    static int[][] map;
    static int[] py = {-1, 1, 0, 0};
    static int[] px = {0, 0, -1, 1};
    static int ans1, ans2;

    public static class P{
        int y;
        int x;
        int d;
        public P(int y, int x, int d){
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int y = 0; y < N; y++){
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        ans1 = BFS(0, 0, map[0][0] == 2 ? true : false);
        
        int answer = ans1 < ans2 ? ans1 : ans2 != 0 ? ans2 : ans1; 

        bw.write(answer <= T ? String.valueOf(answer) : "Fail");
        bw.flush();
        br.close();
        bw.close();
    }

    public static int BFS(int y, int x, boolean hasK){
        Queue<P> q = new LinkedList<>();
        boolean[][] v = new boolean[N][M];

        q.add(new P(y, x, 0));
        v[y][x] = true;

        int depth = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            P now = q.poll();

            if (now.y == N - 1 && now.x == M - 1) depth = Math.min(depth, now.d);

            for (int i = 0; i < 4; i++){
                int nextY = now.y + py[i];
                int nextX = now.x + px[i];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M || v[nextY][nextX]) continue;
                if (!hasK && map[nextY][nextX] == 1) continue;
                if (map[nextY][nextX] == 2){
                    ans2 = now.d + 1 + BFS(nextY, nextX, true);                    
                }

                q.add(new P(nextY, nextX, now.d + 1));                
                v[nextY][nextX] = true;
            }
        }
        return depth;
    }
}