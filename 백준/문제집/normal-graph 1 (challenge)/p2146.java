import java.io.*;
import java.util.*;

public class p2146 {
    static int N;
    static int[][] map;
    static int[] py = {-1, 1, 0, 0};
    static int[] px = {0, 0, -1, 1};
    static int answer = Integer.MAX_VALUE;
    static Queue<P> q;
    static boolean[][] v;

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

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        v = new boolean[N][N];

        StringTokenizer st;
        for (int y = 0; y < N; y++){
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) map[y][x] = Integer.parseInt(st.nextToken());
        }

        int land = 0;

        for (int y = 0; y < N; y++){
            for (int x = 0; x < N; x++){
                if (v[y][x] || map[y][x] == 0) continue;       
                BFS(y, x, ++land);
            }
        }

        for (int y = 0; y < N; y++){
            for (int x = 0; x < N; x++){                
                if (map[y][x] != 0) BridgeBFS(y, x, map[y][x]);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void BFS(int y, int x, int land){
        q = new LinkedList<>();

        q.add(new P(y, x, 0));
        v[y][x] = true;

        while(!q.isEmpty()){
            P now = q.poll();            
            map[now.y][now.x] = land;

            for (int i = 0; i < 4; i++){
                int nextY = now.y + py[i];
                int nextX = now.x + px[i];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N || v[nextY][nextX]) continue;

                if (map[nextY][nextX] == 1){
                    q.add(new P(nextY, nextX, now.d + 1));
                    v[nextY][nextX] = true;
                }
            }
        }
    }

    public static void BridgeBFS(int y, int x, int land){        
        q = new LinkedList<>();
        v = new boolean[N][N];

        q.add(new P(y, x, 0));

        while(!q.isEmpty()){
            P now = q.poll();

            for (int i = 0; i < 4; i++){
                int nextY = now.y + py[i];
                int nextX = now.x + px[i];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N || v[nextY][nextX]) continue;

                if (map[nextY][nextX] == 0){
                    q.add(new P(nextY, nextX, now.d + 1));
                    v[nextY][nextX] = true;
                }

                if (map[nextY][nextX] != 0 && map[nextY][nextX] != land){
                    answer = Math.min(answer, now.d);
                } 
            }
        }
    }
}
