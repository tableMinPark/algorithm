import java.io.*;
import java.util.*;

public class p17129 {
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

    static int[] py = {-1, 1, 0, 0};
    static int[] px = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        Queue<P> q = new LinkedList<>();
        boolean[][] v = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 2) {
                    q.add(new P(i, j, 0));
                    v[i][j] = true;
                }
            }
        }

        BFS(N, M, map, v, q);

        bw.write(sb.toString());       
        br.close();
        bw.flush();
        bw.close();
    }    
    public static void BFS(int N, int M, int[][] map, boolean[][] v, Queue<P> q){
        while(!q.isEmpty()){
            P p = q.poll();

            for (int i = 0; i < 4; i++){
                int nextY = p.y + py[i];
                int nextX = p.x + px[i];


                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M || v[nextY][nextX] || map[nextY][nextX] == 1) continue;
                
                if (map[nextY][nextX] != 0){
                    sb.append("TAK").append("\n").append(p.c + 1);
                    return;
                }
                
                q.add(new P(nextY, nextX, p.c + 1));
                v[nextY][nextX] = true;
            }
        }
        sb.append("NIE");
    }
}
