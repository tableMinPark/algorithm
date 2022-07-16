import java.io.*;
import java.util.*;

public class p11123 {
    public static class P{
        int y;
        int x;
        public P(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    static int[] py = {-1, 1, 0, 0};
    static int[] px = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int testCase = 0; testCase < T; testCase++){
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] map = new char[H][W];
            boolean[][] v = new boolean[H][W];

            int answer = 0;

            for (int y = 0; y < H; y++) map[y] = br.readLine().toCharArray();

            for (int y = 0; y < H; y++){
                for (int x = 0; x < W; x++){     
                    if (v[y][x]) continue;
                    if (map[y][x] == '.') continue;
                    BFS(y, x, H, W, map, v);
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();        
    }
    public static void BFS(int y, int x, int H, int W, char[][] map, boolean[][] v){
        Queue<P> q = new LinkedList<>();
        q.add(new P(y, x));                   
        v[y][x] = true;

        while(!q.isEmpty()){
            P now = q.poll();

            for(int i = 0; i < 4; i++){
                int nextY = now.y + py[i];
                int nextX = now.x + px[i];

                if (nextY < 0 || nextY >= H || nextX < 0 || nextX >= W || map[nextY][nextX] == '.' || v[nextY][nextX]) continue;
                q.add(new P(nextY, nextX));
                v[nextY][nextX] = true;
            }
        }
    }
}
// char[][] 로 쓸것! String[][] 이랑 시간차이가 엄청남!