import java.io.*;
import java.util.*;

public class p15661 {
    static int N;
    static int[][] arr;
    static boolean[] v;

    static int T = 0;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        v = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int idx, int depth){
        if (depth > 0){
            int t1 = 0;
            int t2 = 0;

            for (int i = 0; i < N - 1; i++){
                for (int j = i + 1; j < N; j++){
                    if (!v[i] && !v[j]){
                        t1 += arr[i][j];
                        t1 += arr[j][i];
                    }
                    if (v[i] && v[j]){
                        t2 += arr[i][j];
                        t2 += arr[j][i];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(t1 - t2));
            if (depth == N / 2) return;
        }

        for (int i = idx; i < N; i++){
            if (v[i]) continue;
            v[i] = true;
            DFS(i + 1, depth + 1);
            v[i] = false;
        }
    }
}