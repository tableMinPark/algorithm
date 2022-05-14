import java.io.*;
import java.util.*;

public class s1979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] map = new int[N + 2][N + 2];

            for (int y = 1; y <= N; y++){
                st = new StringTokenizer(br.readLine());
                for (int x = 1; x <= N; x++) map[y][x] = Integer.parseInt(st.nextToken());
            }

            int[] answer = new int[N + 1];

            int[] py = {-1, 1, 0, 0};
            int[] px = {0, 0, -1, 1};

            for (int y = 1; y <= N; y++){
                for (int x = 1; x <= N; x++){

                    if (map[y][x] == 0) continue;

                    int cnt = 1;
                    for (int i = 0; i < 2; i++){
                        int nextY = y + py[i];
                        int nextX = x + px[i];

                        while(map[nextY][nextX] != 0){
                            cnt++;
                            nextY += py[i];
                            nextX += px[i];
                        }
                    }
                    answer[cnt]++;
                    
                    cnt = 1;
                    for (int i = 2; i < 4; i++){
                        int nextY = y + py[i];
                        int nextX = x + px[i];

                        while(map[nextY][nextX] != 0){
                            cnt++;
                            nextY += py[i];
                            nextX += px[i];
                        }
                    }
                    answer[cnt]++;
                }
            }

            sb.append("#").append(t).append(" ").append(answer[K] / K).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}