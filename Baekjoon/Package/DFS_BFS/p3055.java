import java.io.*;
import java.util.*;

public class p3055{
    public static class P implements Comparable<P>{
        int y;
        int x;
        int c;
        public P(int y, int x, int c){
            this.y = y;
            this.x = x;
            this.c = c;
        }
        @Override
        public int compareTo(P p) {
            return this.c - p.c;
        }
    }

    static String[][] map;
    static PriorityQueue<P> g;
    static PriorityQueue<P> w;
    static boolean[][] gv;
    static boolean[][] wv;

    static int[] py = {-1, 1, 0, 0};
    static int[] px = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        map = new String[R][C];
        g = new PriorityQueue<>();
        w = new PriorityQueue<>();
        gv = new boolean[R][C];
        wv = new boolean[R][C];
        
        for (int i = 0; i < R; i++){
            map[i] = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                if (map[i][j].equals("S")) {
                    g.add(new P(i, j, 0));
                    gv[i][j] = true;
                    map[i][j] = ".";
                }
                else if (map[i][j].equals("*")) {
                    w.add(new P(i, j, 0));
                    wv[i][j] = true;
                }
            }
        }

        int answer = 0;

        while(!g.isEmpty()){
            P go = g.poll();
            while(!w.isEmpty() && w.peek().c == go.c){
                P water = w.poll();
                for (int k = 0; k < 4; k++){
                    int nextY = water.y + py[k];
                    int nextX = water.x + px[k];
                    if (nextY < 0 || nextY >= R || nextX < 0 || nextX >= C || wv[nextY][nextX]) continue;
                    if (map[nextY][nextX].equals(".")){
                        map[nextY][nextX] = "*";
                        w.add(new P(nextY, nextX, water.c + 1));
                        wv[nextY][nextX] = true;
                    }
                }
            }

            if (map[go.y][go.x].equals("D")){
                answer = go.c;
                break;
            }
            for (int i = 0; i < 4; i++){
                int nextY = go.y + py[i];
                int nextX = go.x + px[i];
                if (nextY < 0 || nextY >= R || nextX < 0 || nextX >= C || gv[nextY][nextX]) continue;
                if (map[nextY][nextX].equals("*") || map[nextY][nextX].equals("X")) continue;
                g.add(new P(nextY, nextX, go.c + 1));
                gv[nextY][nextX] = true;
            }
        }

        bw.write(answer == 0 ? "KAKTUS" : String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }
}