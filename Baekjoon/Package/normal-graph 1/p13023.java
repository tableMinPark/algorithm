import java.io.*;
import java.util.*;

public class p13023 {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] v;
    static boolean isLine = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int F1 = Integer.parseInt(st.nextToken());
            int F2 = Integer.parseInt(st.nextToken());
            graph[F1].add(F2);
            graph[F2].add(F1);
        }

        for (int i = 0; i < N; i++){
            v = new boolean[N];
            DFS(i, 1);
            if (isLine) break;
        }

        bw.write(String.valueOf(isLine ? 1 : 0));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int start, int depth){
        if (depth == 5){
            isLine = true;
            return;
        }
        
        v[start] = true;
        for (int g : graph[start]){
            if (!v[g]) DFS(g, depth + 1);

            if (isLine) return;
        }
        v[start] = false;
    }
}