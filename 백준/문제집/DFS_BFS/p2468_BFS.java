import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2468_BFS {
    static int N;
    static int[][] map;
    static boolean[][] v;
    static int[] py = {-1, 1, 0, 0};
    static int[] px = {0, 0, -1, 1};
    static int subCount;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());                
            }
        }

        for (int k = 0; k <= 100; k++){ 
            v = new boolean[N][N];
            subCount = 0;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if (!v[i][j] && map[i][j] > k) {
                        BFS(i ,j, k);
                        subCount++;
                    }
                }
            }
            if (subCount > count) count = subCount;                       
            if (check()) break;
        }

        bw.write(Integer.toString(count));
        bw.flush();
        br.close();
        bw.close();        
    }
    public static void BFS(int y, int x, int k){
        Queue<point2468> q = new LinkedList<>();
        q.add(new point2468(y, x));
        v[y][x] = true;

        while (!q.isEmpty()){
            point2468 p = q.poll();

            for (int i = 0; i < 4; i++){
                int nextY = p.y + py[i];
                int nextX = p.x + px[i];
                if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= N) continue;
                if (v[nextY][nextX] || map[nextY][nextX] <= k) continue;
                q.add(new point2468(nextY, nextX));
                v[nextY][nextX] = true;
            }
        }
    }
    public static boolean check(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (v[i][j]) return false;
            }
        }
        return true;
    }
}

class point2468{
    int y;
    int x;

    point2468(int y, int x){
        this.y = y;
        this.x = x;
    }
}
