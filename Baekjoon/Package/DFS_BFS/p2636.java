import java.io.*;
import java.util.*;

public class p2636 {
    static int[] px = {-1, 1, 0, 0};
    static int[] py = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] v;
    static Queue<P> q;

    static int R;
    static int C;
    static int answer = 0;

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

        map = new int[R][C];

        for (int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();

        int pChC = 0;
        int chC = 0;
        while((chC = BFS()) > 0){
            pChC = chC;
            answer++;
        }
        sb.append(answer).append("\n").append(pChC);
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
    public static int BFS(){
        q = new LinkedList<>();
        v = new boolean[R][C];

        q.add(new P(0, 0));
        v[0][0] = true;
        
        int cheeseCount = 0;

        while(!q.isEmpty()){
            P p = q.poll();

            for (int i = 0; i < 4; i++){
                int nextY = p.y + py[i];
                int nextX = p.x + px[i];
                
                if (nextY < 0 || nextY >= R || nextX < 0 || nextX >= C || v[nextY][nextX]) continue;
                if (map[nextY][nextX] != 1) q.add(new P(nextY, nextX));
                if (map[nextY][nextX] == 1) cheeseCount++;
                v[nextY][nextX] = true;
            }
        }

        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if (v[i][j]) map[i][j] = 0;
            }
        }

        return cheeseCount;
    }
}
