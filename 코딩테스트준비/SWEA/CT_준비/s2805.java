import java.io.*;

public class s2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++){
                String[] input = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            int idx = N / 2;
            int cnt = 1;
            int sum = 0;

            for (int y = 0; y <= N / 2; y++){
                for (int x = idx; x < idx + cnt; x++){
                    sum += map[y][x];
                }
                idx--;
                cnt += 2;
            }

            idx = N / 2;
            cnt = 1;

            for (int y = N - 1; y > N / 2; y--){
                for (int x = idx; x < idx + cnt; x++){
                    sum += map[y][x];
                }
                idx--;
                cnt += 2;
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}