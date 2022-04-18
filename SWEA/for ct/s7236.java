import java.io.*;
import java.util.*;

public class s7236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] px = {0, 0, -1, 1, -1, -1, 1, 1};
        int[] py = {1, -1, 0, 0, 1, -1, 1, -1};

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];

            for (int y = 0; y < N; y++){
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++){
                    map[y][x] = st.nextToken().equals("G") ? 0 : 1;
                }
            }

            int answer = 0;

            for (int y = 1; y < N - 1; y++){
                for (int x = 1; x < N - 1; x++){
                    if (map[y][x] == 0) continue;
                    int cnt = 0;
                    for (int i = 0 ; i < 8; i++){
                        int nextX = x + px[i];
                        int nextY = y + py[i];
                        if (map[nextY][nextX] == 1) cnt++;
                    }

                    if (cnt == 0) cnt = 1;

                    answer = Math.max(answer, cnt);
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}