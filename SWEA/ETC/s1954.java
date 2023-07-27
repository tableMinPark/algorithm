import java.io.*;

public class s1954 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];

            int idx = 0;
            int y = 0;
            int x = 0;
            int d = 0;

            int[] py = {0, 1, 0, -1};
            int[] px = {1, 0, -1, 0};

            while(idx < N * N){
                map[y][x] = ++idx;

                int ny = y + py[d];
                int nx = x + px[d];
                if (ny >= N || ny < 0 || nx >= N || nx < 0 || map[ny][nx] != 0){
                    d++;
                    if (d > 3) d = 0;
                    y += py[d];
                    x += px[d];
                } else{
                    y = ny;
                    x = nx;
                }
            }

            sb.append("#").append(t).append("\n");
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++) sb.append(map[i][j]).append(" ");
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}