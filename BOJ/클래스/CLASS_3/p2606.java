import java.io.*;
import java.util.*;

public class p2606 {
    static int N, K, answer;
    static List<Integer>[] graph;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            graph[B].add(A);
        }
        
        v = new boolean[N + 1];
        answer = 0;
        dfs(1);

        System.out.println(answer);
        br.close();
    }

    static void dfs(int n){
        v[n] = true;

        for (int node : graph[n]){
            if (v[node]) continue;
            dfs(node);
            answer++;
        }
    }
}