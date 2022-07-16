import java.io.*;
import java.util.*;

public class p11724 {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        v = new boolean[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        int answer = 0;

        for (int i = 1; i <= N; i++){
            if (v[i]) continue;
            DFS(i);
            answer++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int now){
        v[now] = true;
        for (int next : graph[now]){
            if (!v[next]) DFS(next);
        }
    }
}