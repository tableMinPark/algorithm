import java.io.*;
import java.util.*;

public class p16431 {
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

    static P[] cow = new P[2];
    static P J;

    static int[] py = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] px = {-1, 1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        for (int i = 0; i < 2; i++){
            st = new StringTokenizer(br.readLine());
            cow[i] = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
        }
        st = new StringTokenizer(br.readLine());
        J = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        int[] count = new int[2];

        for (int i = 0; i < 2; i++){
            Queue<P> q = new LinkedList<>();
            boolean[][] v = new boolean[1000][1000];

            q.add(cow[i]);
            v[cow[i].y][cow[i].x] = true;

            while(!q.isEmpty()){
                P p = q.poll();

                if (p.y == J.y && p.x == J.x){
                    count[i] = p.c;
                    break;
                }

                int idx = i == 0 ? 8 : 4;
                for (int j = 0; j < idx; j++){
                    int nextY = p.y + py[j];
                    int nextX = p.x + px[j];

                    if (nextY < 0 || nextY >= 1000 || nextX < 0 || nextX >= 1000 || v[nextY][nextX]) continue;

                    q.add(new P(nextY, nextX, p.c + 1));
                    v[nextY][nextX] = true;
                }
            }
        }

        if (count[0] == count[1]) bw.write("tie");
        else if (count[0] < count[1]) bw.write("bessie");
        else if (count[0] > count[1]) bw.write("daisy");

        br.close();
        bw.flush();
        bw.close();
    }

    public static void BFS(P[] cow){
        
        
    }
}
