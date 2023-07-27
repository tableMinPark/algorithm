import java.io.*;
import java.util.*;

public class p1012 {
    static int[] px = {-1, 1, 0, 0};
    static int[] py = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] v;
    static Queue<P> q;

    static int M;
    static int N;
    static int K;

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

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int testcase = 0; testcase < T; testcase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            v = new boolean[N][M];
            q = new LinkedList<>();

            for (int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int answer = 0;

            for (int y = 0; y < N; y++){
                for (int x = 0; x < M; x++){
                    if (map[y][x] == 1 && !v[y][x]){
                        q.add(new P(y, x));
                        v[y][x] = true;     //방문표시 수정후

                        while(!q.isEmpty()){
                            P p = q.poll();
                            //v[p.y][p.x] = true      //방문표시 수정전 (큐에서 뺀 뒤 방문표시를 하게 되면 여러 정점에서 한 정점을 같은 시간에 방문하려할 때 방문 표시가 계속 되어있지 않아 여러번 큐에 들어가게된다.)
            
                            for (int i = 0; i < 4; i++){
                                int nextY = p.y + py[i];
                                int nextX = p.x + px[i];
            
                                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) continue;
                                if (v[nextY][nextX]) continue;
            
                                if (map[nextY][nextX] == 1) {
                                    q.add(new P(nextY, nextX));
                                    v[nextY][nextX] = true;     //방문표시 수정후
                                }
                            }
                        }
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");            
        }
        
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
