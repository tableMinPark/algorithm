import java.io.*;
import java.util.*;

public class p7562 {
    public static class P{
        int y;
        int x;
        int m;
        public P(int y, int x, int m){
            this.y = y;
            this.x = x;
            this.m = m;
        }
    }

    static int[] py = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] px = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int testCase = 0; testCase < T; testCase++){
            int I = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            P s = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            P e = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            
            Queue<P> q = new LinkedList<>();
            boolean[][] v = new boolean[I][I];

            q.add(s);
            v[s.y][s.x] = true;

            while(!q.isEmpty()){
                P p = q.poll();

                if (p.y == e.y && p.x == e.x){
                    sb.append(p.m).append("\n");
                    break;
                }
                for (int i = 0; i < 8; i++){
                    int nextY = p.y + py[i];
                    int nextX = p.x + px[i];

                    if (nextY < 0 || nextY >= I || nextX < 0 || nextX >= I || v[nextY][nextX]) continue;
                    
                    q.add(new P(nextY, nextX, p.m + 1));
                    v[nextY][nextX] = true;
                }
            }
        }
        
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
