import java.io.*;
import java.util.*;

public class p10971 {
    static int N;
    static int[][] map;
    static boolean[] v;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        v = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0, 0, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int start, int value, int depth, int city){
        if (depth == N && start == city){
            answer = answer > value ? value : answer;
            return;
        }

        for (int i = 0; i < N; i++){
            if (v[i]) continue;
            if (map[start][i] == 0) continue;
            v[i] = true;
            DFS(i, value + map[start][i], depth + 1, city);
            v[i] = false;
        }
    }
}