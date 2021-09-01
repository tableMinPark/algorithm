import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p2667_DFS {
    static int c;
    static int[][] map;
    static boolean[][] v;
    static int[] py = {-1, 1, 0, 0};
    static int[] px = {0, 0, -1, 1};
    static int subCount;
    static List<Integer> count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        c = Integer.parseInt(br.readLine());
        map = new int[c][c];
        v = new boolean[c][c];
        
        for (int i = 0; i < c; i++){
            String t = br.readLine();
            for (int j = 0; j < c; j++) map[i][j] = t.charAt(j)-'0';
        }

        count = new ArrayList<>();

        for (int i = 0; i < c; i++){
            for (int j = 0; j < c; j++){
                if (!v[i][j] && map[i][j] == 1){
                    subCount = 0;
                    DFS(i, j);
                    count.add(subCount);
                } 
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count.size()).append("\n");

        Collections.sort(count);

        for (int i = 0; i < count.size(); i++){            
            sb.append(count.get(i)).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
    public static void DFS(int y, int x){
        v[y][x] = true;
        subCount++;
        for (int i = 0; i < 4; i++){
            int nextY = y + py[i];
            int nextX = x + px[i];
            if (nextY < 0 || nextX < 0 || nextY >= c || nextX >= c) continue;
            if (v[nextY][nextX] || map[nextY][nextX] == 0) continue;

            DFS(nextY, nextX);
        }
    }
}
