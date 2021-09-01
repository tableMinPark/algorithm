import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7569 {
    static int M;
    static int N;
    static int H;
    static int[][][] map;
    static boolean[][][] v;
    static int c = 0;
    static int[] pz = {0, 0, 0, 0, 1, -1};  //상 하 좌 우 위 아래
    static int[] py = {-1, 1, 0, 0, 0, 0};
    static int[] px = {0, 0, -1, 1, 0, 0};
    static Queue<tomato> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        v = new boolean[H][N][M];
        q = new LinkedList<>();

        for (int i = 0; i < H; i++){
            for (int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1){
                        q.add(new tomato(i, j, k, 0));
                        v[i][j][k] = true;
                    }
                 }
            }
        }

        BFS();

        if (!check()) c = -1;
        bw.write(Integer.toString(c));

        bw.flush();
        br.close();
        bw.close();
    }
    public static void BFS(){
        while(!q.isEmpty()){
            tomato t = q.poll();

            if (t.count > c) c = t.count;

            for (int i = 0; i < 6; i++){
                int nextZ = t.z + pz[i];
                int nextY = t.y + py[i];
                int nextX = t.x + px[i];

                if (nextY < 0 || nextX < 0 || nextZ < 0 || nextY >= N || nextX >= M || nextZ >= H) continue;
                if (v[nextZ][nextY][nextX] || map[nextZ][nextY][nextX] == -1) continue;

                q.add(new tomato(nextZ, nextY, nextX, t.count + 1));
                v[nextZ][nextY][nextX] = true;
            }
        }
    }
    public static boolean check(){
        for (int i = 0; i < H; i++){
            for (int j = 0; j < N; j++){
                for (int k = 0; k < M; k++){
                    if (!v[i][j][k] && map[i][j][k] != -1) return false;
                 }
            }
        }
        return true;
    }
}
class tomato{
    int z;
    int y;
    int x;
    int count;

    tomato(int z, int y, int x, int count){
        this.z = z;
        this.y = y;
        this.x = x;
        this.count = count;
    }
}