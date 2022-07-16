import java.io.*;
import java.util.*;

public class p10026 {
    static int N;

    static char[][] map;
    static boolean[][] v;

    static int[] py = {-1, 1, 0, 0};
    static int[] px = {0, 0, -1, 1};

    public static class P{
        int y;
        int x;
        public P(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for (int y = 0; y < N; y++) map[y] = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 2; i++){
            v = new boolean[N][N];
            int count = 0;

            for (int y = 0; y < N; y++){
                for (int x = 0; x < N; x++){
                    if (v[y][x]) continue;
                    BFS(y, x);
                    count++;
                }
            }
            sb.append(count).append(" ");
        }
        
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static void BFS(int y, int x){
        Queue<P> q = new LinkedList<>();
        q.add(new P(y, x));
        v[y][x] = true;

        char startColor = map[y][x];

        while(!q.isEmpty()){
            P now = q.poll();

            if (startColor == 'G') map[now.y][now.x] = 'R';

            for(int i = 0; i < 4; i++){
                int nextY = now.y + py[i];
                int nextX = now.x + px[i];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N || v[nextY][nextX]) continue;
                if (map[nextY][nextX] != startColor) continue;
                q.add(new P(nextY, nextX));
                v[nextY][nextX] = true;
            }
        }
    }
}
