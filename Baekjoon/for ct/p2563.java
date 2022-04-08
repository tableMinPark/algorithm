import java.io.*;
import java.util.*;

public class p2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[][] arr = new boolean[101][101];

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            for (int x = X; x <= X + 9; x++){
                for (int y = Y; y <= Y + 9; y++){
                    if (!arr[y][x]) arr[y][x] = true;
                }
            }
        }

        int sum = 0;
        for (int x = 1; x <= 100; x++){
            for (int y = 1; y <= 100; y++){
                if (!arr[y][x]) continue;
                if (arr[y][x]) sum++;
            }
        }

        bw.write(String.valueOf(sum));
        br.close();
        bw.flush();
        bw.close();
    }
}