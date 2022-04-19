import java.io.*;
import java.util.*;

public class s1974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int[][] map = new int[9][9];
            
            for (int i = 0; i < 9; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            int answer = 1;
            boolean[] v;

    LOOP:   for (int i = 0; i < 9; i++){
                v = new boolean[10];
                for (int x = 0; x < 9; x++){
                    if (!v[map[i][x]]) v[map[i][x]] = true;
                    else{
                        answer = 0;
                        break LOOP;
                    }
                }

                v = new boolean[10];
                for (int y = 0; y < 9; y++){
                    if (!v[map[y][i]]) v[map[y][i]] = true;
                    else{
                        answer = 0;
                        break LOOP;
                    }
                }
            }

            int[] py = {-1, 1, 0, 0, -1, -1, 1, 1};
            int[] px = {0, 0, -1, 1, -1, 1, -1, 1};

    LOOP:   for (int y = 1; y < 9; y += 3){
                for (int x = 1; x < 9; x += 3){
                    v = new boolean[10];
                    v[map[y][x]] = true;

                    for (int i = 0; i < 8; i++){
                        int nextY = y + py[i];
                        int nextX = x + px[i];

                        if (!v[map[nextY][nextX]]) v[map[nextY][nextX]] = true;
                        else{
                            answer = 0;
                            break LOOP;
                    }
                    }
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