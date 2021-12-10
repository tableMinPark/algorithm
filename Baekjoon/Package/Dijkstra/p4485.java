import java.io.*;
import java.util.*;

public class p4485{
    static int[] py = {-1, 1, 0, 0};
    static int[] px = {0, 0, -1, 1};

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
        public int compareTo(P p){
            return this.c - p.c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N;

        StringBuilder sb = new StringBuilder();
        int caseNum = 1;

        while ((N = Integer.parseInt(br.readLine())) != 0){
            int[][] map = new int[N][N];
            int[][] value = new int[N][N];

            for (int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    value[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<P> q = new PriorityQueue<>();
            q.add(new P(0, 0, map[0][0]));

            while(!q.isEmpty()){
                P p = q.poll();

                for (int i = 0; i < 4; i++){
                    int nextY = p.y + py[i];
                    int nextX = p.x + px[i];

                    if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) continue;
                    
                    int nextC = p.c + map[nextY][nextX];
                    if (nextC < value[nextY][nextX]){
                        value[nextY][nextX] = nextC;
                        q.add(new P(nextY, nextX, nextC));
                    }
                }
            }
            sb.append("Problem ").append(caseNum++).append(": ").append(value[N - 1][N - 1]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}