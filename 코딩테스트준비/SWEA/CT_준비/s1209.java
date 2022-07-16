import java.io.*;
import java.util.*;

public class s1209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        for (int t = 1; t <= 10; t++){
            int T = Integer.parseInt(br.readLine());
            int[][] map = new int[100][100];

            int[] ys = new int[100];
            int ssum = 0;
            int esum = 0;

            int max = 0;
            int idx = 99;

            for (int i = 0; i < 100; i++){
                st = new StringTokenizer(br.readLine());

                int xs = 0;
                for (int j = 0; j < 100; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    xs += map[i][j];
                    ys[j] += map[i][j];

                    if (i == j) ssum += map[i][j];
                    if (j == idx--) esum += map[i][j];
                }
                max = Math.max(max, xs);
            }

            for (int i = 0; i < 100; i++) max = Math.max(max, ys[i]);

            max = Math.max(max, ssum);
            max = Math.max(max, esum);

            sb.append("#").append(T).append(" ").append(max).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}