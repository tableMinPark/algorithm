import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p16918 {
    static int R;
    static int C;
    static int N;
    static String[][] map;
    static boolean[][] v;
    static int[] px = {-1, 1, 0, 0};
    static int[] py = {0, 0, -1, 1};
    static Queue<P> q;

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

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new String[R][C];
        v = new boolean[R][C];
        q = new LinkedList<>();

        for (int y = 0; y < R; y++){
            String[] t = br.readLine().split("");
            for (int x = 0; x < C; x++){
                map[y][x] = t[x];
                if (map[y][x].equals("O")) q.add(new P(y, x));
            }
        }

        if (N % 2 != 0) for (int i = 3; i <= N; i += 2) BFS();
        
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < R; y++){
            for (int x = 0; x < C; x++){
                if (N % 2 == 0) sb.append("O");
                else sb.append(map[y][x]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static void BFS(){
        while(!q.isEmpty()){
            P p = q.poll();
            map[p.y][p.x] = ".";
            v[p.y][p.x] = true;

            for (int i = 0; i < 4; i++){
                int nextY = p.y + py[i];
                int nextX = p.x + px[i];

                if (nextX < 0 || nextX >= C || nextY < 0 || nextY >= R) continue;
                v[nextY][nextX] = true;
            }
        }
        for (int y = 0; y < R; y++){
            for (int x = 0; x < C; x++){
                if (!v[y][x]){
                    q.add(new P(y, x));
                    map[y][x] = "O";
                    v[y][x] = true;
                }
                else {
                    map[y][x] = ".";
                    v[y][x] = false;
                }
            }
        }
    }
}
