import java.io.*;
import java.util.*;

public class p2578 {
    static boolean[][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] p = new int[26][2];
        v = new boolean[5][5];

        StringTokenizer st;

        for (int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int n = Integer.parseInt(st.nextToken());
                p[n][0] = i;        // y
                p[n][1] = j;        // x
            }
        }

        int cnt = 0;

        for (int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++){
                int n = Integer.parseInt(st.nextToken());
                v[p[n][0]][p[n][1]] = true;
                cnt++;
                if (check()) {
                    bw.write(String.valueOf(cnt));
                    bw.flush();
                    return;
                }
            }
        }

        br.close();
        bw.close();
    }

    public static boolean check(){
        int cnt = 0;

        // 가로세로
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                if (!v[i][j]) break;
                if (j == 4) cnt++;
            }
            for (int j = 0; j < 5; j++){
                if (!v[j][i]) break;
                if (j == 4) cnt++;
            }
        }

        // \ 대각선
        for (int i = 0; i < 5; i++){
            if (!v[i][i]) break;
            if (i == 4) cnt++;
        }
        // / 대각선
        for (int i = 0, j = 4; i < 5; i++, j--){
            if (!v[i][j]) break;
            if (i == 4) cnt++;
        }

        return cnt >= 3;
    }
}