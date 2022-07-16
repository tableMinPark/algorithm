import java.io.*;
import java.util.*;

public class p10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] map = new int[1001][1001];

        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for (int x = sx; x < sx + w; x++){
                for (int y = sy; y < sy + h; y++) map[y][x] = i;
            }
        }

        int[] ans = new int[101];

        for (int i = 0; i < 1001; i++){
            for (int j = 0; j < 1001; j++){
                if (map[i][j] == 0) continue;
                ans[map[i][j]]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++){
            sb.append(ans[i]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}