import java.io.*;
import java.util.*;

public class p6593 {
    public static class P{
        int z;
        int y;
        int x;
        int c;
        public P(int z, int y, int x, int c){
            this.z = z;
            this.y = y;
            this.x = x;
            this.c = c;
        }
    }
    //상-히-좌-우-위-아래
    static int[] pz = {1, -1, 0, 0, 0, 0};
    static int[] py = {0, 0, 0, 0, 1, -1};
    static int[] px = {0, 0, -1, 1, 0, 0};

    static int L;
    static int R;
    static int C;
    static String[][][] map;
    static boolean[][][] v;
    static Queue<P> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());   //층 - z
            R = Integer.parseInt(st.nextToken());   //행 - y
            C = Integer.parseInt(st.nextToken());   //열 - x

            if (L == 0 && R == 0 && C == 0) break;

            map = new String[L][R][C];
            v = new boolean[L][R][C];
            q = new LinkedList<>();

            for (int z = 0; z < L; z++){
                for (int y = 0; y < R; y++){
                    String[] input = br.readLine().split("");
                    for (int x = 0; x < C; x++){
                        map[z][y][x] = input[x];
                        if (map[z][y][x].equals("S")){
                            q.add(new P(z, y, x, 0));
                            v[z][y][x] = true;
                        }
                    }
                }
                br.readLine();
            }
            int answer = BFS();
            sb.append(answer == 0 ? "Trapped!" : "Escaped in " + answer + " minute(s).").append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();        
    }
    public static int BFS(){        
        while(!q.isEmpty()){
            P p = q.poll();

            for (int i = 0; i < 6; i++){
                int nextZ = p.z + pz[i];
                int nextY = p.y + py[i];
                int nextX = p.x + px[i];
                int nextC = p.c + 1;

                if (nextZ < 0 || nextZ >= L) continue;
                if (nextY < 0 || nextY >= R) continue;
                if (nextX < 0 || nextX >= C) continue;
                if (v[nextZ][nextY][nextX]) continue;
                if (map[nextZ][nextY][nextX].equals("#")) continue;
                if (map[nextZ][nextY][nextX].equals("E")) return nextC;
                q.add(new P(nextZ, nextY, nextX, nextC));
                v[nextZ][nextY][nextX] = true;
            }
        }
        return 0;
    }
}
