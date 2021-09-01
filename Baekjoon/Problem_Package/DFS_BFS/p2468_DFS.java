import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p2468_DFS {
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
        
        count = 0;

        for (int k = 0; k <= 100; k++){ 
            v = new boolean[N][N];
            subCount = 0;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if (!v[i][j] && map[i][j] > k) {
                        DFS(i ,j, k);
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

    public static void DFS(int y, int x, int n){
        v[y][x] = true;
        for (int i = 0; i < 4; i++){
            int nextY = y + py[i];
            int nextX = x + px[i];
            if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= N) continue;
            if (v[nextY][nextX] || map[nextY][nextX] <= n) continue;
            DFS(nextY, nextX, n);
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