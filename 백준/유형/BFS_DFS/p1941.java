import java.io.*;
import java.util.*;

public class p1941 {

    static int answer;
    static char[][] map;
    static boolean[][] v;
    static int[] dy = {0, -1, 0, -1,  0, -1, 0, -1};
    static int[] dx = {1, 0,  -1, 0,  1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[5][5];
        for (int y = 0; y < 5; y++) map[y] = br.readLine().toCharArray();

        

        System.out.println(answer);
        br.close();
    }

    static void dfs(int y, int x, int d, int count, int start){
        if (d == 7){
            System.out.println(y + " " + x);
            if (count >= 4) {        // 4번조건
                answer++;        
            }
            return;
        }

        for (int i = start; i < start + 2; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (nextY < 0 || nextY >= 5 || nextX < 0 || nextX >= 5) continue;
            if (v[nextY][nextX]) continue;

            v[nextY][nextX] = true;
            dfs(nextY, nextX, d + 1, count + (map[nextY][nextX] == 'S' ? 1 : 0), start);
        }
    }
}