import java.io.*;
import java.util.*;

public class s1493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int answer = 0;

            int[] pa = getPoint(p);
            int[] qa = getPoint(q);

            int sx = pa[0] + qa[0];
            int sy = pa[1] + qa[1];

            answer = getP(sx, sy);

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static int getP(int x, int y){
        int idx = 1;
        for (int i = 1;; i++){
            for (int nx = 1, ny = i; nx <= i; nx++, ny--){
                if (ny == y && nx == x) return idx;
                idx++;
            }
        }
    }

    public static int[] getPoint(int p){
        int idx = 1;
        for (int i = 1;; i++){
            for (int nx = 1, ny = i; nx <= i; nx++, ny--){
                if (idx == p) return new int[]{nx, ny};
                idx++;
            }
        }
    }
}