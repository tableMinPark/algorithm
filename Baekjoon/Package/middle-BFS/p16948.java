import java.io.*;
import java.util.*;

public class p16948 {
    static int N;
    static int[] py = {-2, -2, 0, 0, 2, 2};
    static int[] px = {-1, 1, -2, 2, -1, 1};
    static int answer = Integer.MAX_VALUE;

    public static class P{
        int y;
        int x;
        int c;
        public P(int y, int x, int c){
            this.y = y;
            this.x = x;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        BFS(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        
        bw.write(answer == Integer.MAX_VALUE ? "-1" : String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void BFS(int sy, int sx, int dy, int dx){
        Queue<P> q = new LinkedList<>();
        boolean[][] v = new boolean[N][N];

        q.add(new P(sy, sx, 0));
        v[sy][sx] = true;

        while(!q.isEmpty()){
            P now = q.poll();

            if (now.y == dy && now.x == dx) answer = Math.min(answer, now.c);

            for (int i = 0; i < 6; i++){
                int nextY = now.y + py[i];
                int nextX = now.x + px[i];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N || v[nextY][nextX]) continue;

                q.add(new P(nextY, nextX, now.c + 1));
                v[nextY][nextX] = true;
            }
        }
    }
}