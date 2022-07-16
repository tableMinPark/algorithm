import java.io.*;
import java.util.*;

public class p16509 {
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

    //static int[] py = {3, 3, 2, -2, -3, -3, -2, 2};
    //static int[] px = {-2, 2, 3, 3, 2, -2, -3, -3};

    static int[][] py = {{1, 2, 3}, 
                        {1, 2, 3},
                        {0, 1, 2},
                        {0, -1, -2},
                        {-1, -2, -3},
                        {-1, -2, -3},
                        {0, -1, -2},
                        {0, 1, 2}};

    static int[][] px = {{0, -1, -2}, 
                        {0, 1, 2},
                        {1, 2, 3},
                        {1, 2, 3},
                        {0, 1, 2},
                        {0, -1, -2},
                        {-1, -2, -3},
                        {-1, -2, -3}};

    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        P start = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
        
        st = new StringTokenizer(br.readLine());
        P end = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        boolean[][] v = new boolean[10][9];
        Queue<P> q = new LinkedList<>();
        q.add(start);
        v[start.y][start.x] = true;

        BFS(v, q, end);

        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? -1 : answer));
        br.close();
        bw.flush();
        bw.close();
    }    
    public static void BFS(boolean[][] v, Queue<P> q, P end){
        while(!q.isEmpty()){
            P p = q.poll();

            for (int i = 0; i < 8; i++){
                int nextY = p.y + py[i][2];
                int nextX = p.x + px[i][2];

                for (int j = 0; j < 3; j++){
                    int nextYTemp = p.y + py[i][j];
                    int nextXTemp = p.x + px[i][j];
                    if (nextYTemp == end.y && nextXTemp == end.x && j < 2) {
                        nextY = -1;
                        nextX = -1;
                        break;
                    }
                }
                if (nextY == -1 && nextX == -1) continue;
                if (nextY < 0 || nextY >= 10 || nextX < 0 || nextX >= 9 || v[nextY][nextX]) continue;
                
                if (nextY == end.y && nextX == end.x && p.c + 1 < answer) answer = p.c + 1;

                q.add(new P(nextY, nextX, p.c + 1));
                v[nextY][nextX] = true;
            }
        }
    }
}
