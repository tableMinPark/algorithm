import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7576 {
    static int M;
    static int N;
    static int[][] map;
    static boolean[][] v;
    static Queue<P> q = new LinkedList<>();
    static int answer = 0;

    static int[] px = {-1, 1, 0, 0};
    static int[] py = {0, 0, -1, 1};

    public static class P{
        int y;
        int x;
        int day;

        public P(int y, int x, int day){
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new boolean[N][M];

        for (int y = 0; y < N; y++){
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 1){
                    q.add(new P(y, x, 0));
                    v[y][x] = true;
                }
            }
        }
        BFS();
        for (int y = 0; y < N; y++){
            for (int x = 0; x < M; x++){
                if (map[y][x] == 0){
                    answer = -1;
                    break;
                }
            }
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }

    public static void BFS(){
        while(!q.isEmpty()){
            P p = q.poll();
            if (answer < p.day) answer = p.day;

            for (int i = 0; i < 4; i++){
                int y = p.y + py[i];
                int x = p.x + px[i];

                if (x < 0 || x >= M || y < 0 || y >= N) continue;
                if (map[y][x] == 0 && !v[y][x]){
                    map[y][x] = 1;
                    v[y][x] = true;
                    q.add(new P(y, x, p.day + 1));
                }
            }
        }
    }
}
