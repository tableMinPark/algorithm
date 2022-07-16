import java.io.*;
import java.util.*;

public class p2567 {
    static int[] px = {0, 0, -1, 1};
    static int[] py = {-1, 1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[101][101];
        
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            for (int x = X; x < X + 10; x++){
                for (int y = Y; y < Y + 10; y++){
                    arr[y][x] = true;
                }
            }
        }
        
        int sum = 0;

        for (int x = 1; x <= 100; x++){
            for (int y = 1; y <= 100; y++){
                if (!arr[y][x]) continue;
                for (int i = 0; i < 4; i++){
                    int nextX = x + px[i];
                    int nextY = y + py[i];   
                    
                    if (nextY < 0 || nextY > 100 || nextX < 0 || nextX > 100) continue;
                    if (arr[nextY][nextX]) continue;
                    sum++;
                }
            }
        }

        bw.write(String.valueOf(sum));
        br.close();
        bw.flush();
        bw.close();
    }
}

