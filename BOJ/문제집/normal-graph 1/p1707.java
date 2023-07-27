import java.io.*;
import java.util.*;

public class p1707 {
    static int V, E;
    static List<Integer>[] graph;
    static int[] color;
    static boolean check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int testCase = 0; testCase < K; testCase++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            color = new int[V + 1];
            for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

            for (int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }
            check = true;
            for (int i = 1; i <= V; i++){
                if (color[i] != 0) continue;
                DFS(i, 1);
            }
            sb.append(check ? "YES" : "NO").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int now, int c){
        color[now] = c;
        for (int next : graph[now]){
            if (color[next] == c){
                check = false;
                return;
            }
            if (color[next] == 0) DFS(next, -c);
        }
    }
}

// 이분그래프에 대해 참고한 사이트 >> https://hongjw1938.tistory.com/117