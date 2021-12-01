import java.io.*;
import java.util.*;

public class p5547 {
    static int[][] map;
    static boolean[][] v;
    static Queue<P> q;
    static int[][] py = {{1, 1, 0, 0, -1, -1}, {1, 1, 0, 0, -1, -1}};
    static int[][] px = {{-1, 0, -1, 1, -1, 0}, {0, 1, -1, 1, 0, 1}};

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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        map = new int[H + 2][W + 2];
        v = new boolean[H + 2][W + 2];
        q = new LinkedList<>();

        for (int i = 1; i <= H; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q.add(new P(0, 0));
        v[0][0] = true;

        while (!q.isEmpty()){
            P p = q.poll();

            for (int i = 0; i < 6; i++){
                int nextY = p.y + py[p.y % 2][i];
                int nextX = p.x + px[p.y % 2][i];

                if (nextY < 0 || nextY >= H + 2 || nextX < 0 || nextX >= W + 2) continue;
                if (map[nextY][nextX] == 0 && !v[nextY][nextX]){
                    v[nextY][nextX] = true;
                    q.add(new P(nextY, nextX));
                }
            }            
        }

        int answer = 0;
        for (int i = 1; i <= H; i++){
            for (int j = 1; j <= W; j++){
                if (map[i][j] == 0) continue;
                for (int k = 0; k < 6; k++){
                    int nextY = i + py[i % 2][k];
                    int nextX = j + px[i % 2][k];
                    if (v[nextY][nextX]) answer++;
                }
            }
        }
        
        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }
}
