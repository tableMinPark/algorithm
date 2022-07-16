import java.io.*;
import java.util.*;

public class p10217 {
    public static class Node implements Comparable<Node>{
        int n;
        int w;
        int m;
        public Node(int n, int m, int w){
            this.n = n;
            this.m = m;
            this.w = w;
        }
        @Override
        public int compareTo(Node node){
            return this.w - node.w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int test = 0; test < testCase; test++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<Node>[] graph = new ArrayList[N + 1];
            int[][] value = new int[N + 1][M + 1];

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
                Arrays.fill(value[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                int D = Integer.parseInt(st.nextToken());
                graph[U].add(new Node(V, C, D));
            }
            Dijkstra(N, M, graph, value);

            int answer = Integer.MAX_VALUE;
            for (int i = 0; i <= M; i++) answer = Math.min(value[N][i], answer);
            sb.append(answer == Integer.MAX_VALUE ? "Poor KCM" : answer).append("\n");            
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static void Dijkstra(int N, int M, List<Node>[] graph, int[][] value){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0, 0));
        value[1][0] = 0;

        while(!q.isEmpty()){
            Node node = q.poll();
            if (node.n == N) break;
    
            for (Node next : graph[node.n]){
                int nextN = next.n;
                int nextW = next.w + node.w;
                int nextM = next.m + node.m;
                
                if (nextM > M) continue;                        //continue를 통해 조건을 분리하면 더 빠르다.
                if (value[nextN][nextM] <= nextW) continue;      
                value[nextN][nextM] = nextW;
                q.add(new Node(nextN, nextM, nextW));
            }
        }
    }
}
