import java.io.*;
import java.util.*;

public class p2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[][] map = new boolean[101][101];

        StringTokenizer st;
        for (int i = 0; i < 4; i++){
            st = new StringTokenizer(br.readLine());
            int X1 = Integer.parseInt(st.nextToken());
            int Y1 = Integer.parseInt(st.nextToken());
            int X2 = Integer.parseInt(st.nextToken());
            int Y2 = Integer.parseInt(st.nextToken());


            for (int x = X1; x < X2; x++){
                for (int y = Y1; y < Y2; y++){
                    map[x][y] = true;                    
                }
            }
        }

        int cnt = 0;

        for (int x = 0; x < 101; x++){
            for (int y = 0; y < 101; y++){
                if (map[x][y]) cnt++;
            }
        }

        bw.write(String.valueOf(cnt));

        br.close();
        bw.flush();
        bw.close();
    }
}