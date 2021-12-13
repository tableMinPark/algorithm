import java.io.*;
import java.util.*;

public class p1238{
    public static class Node implements Comparable<Node>{
        int n;
        int w;
        public Node(int n, int w){
            this.n = n;
            this.w = w;
        }
        @Override
        public int compareTo(Node n){
            return this.w - n.w;
        }
    }

    static int N;
    static int M;
    static int X;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[N + 1];
        List<Node>[] rGraph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            rGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B, T));
            rGraph[B].add(new Node(A, T));
        }
        int answer = 0;

        int[] xToN = dijkstra(graph);
        int[] nToX = dijkstra(rGraph);

        for (int i = 1; i <= N; i++){
            if (answer < xToN[i] + nToX[i]) answer = xToN[i] + nToX[i];
        }
        
        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }
    public static int[] dijkstra(List<Node>[] graph){
        int[] value = new int[N + 1];
        for (int i = 1; i <= N; i++) value[i] = Integer.MAX_VALUE;

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(X, 0));
        value[X] = 0;

        while(!q.isEmpty()){
            Node now = q.poll();
            int nowN = now.n;
            int nowW = now.w;

            for (Node next : graph[nowN]){
                int nextN = next.n;
                int nextW = next.w + nowW;

                if (value[nextN] > nextW){
                    value[nextN] = nextW;
                    q.add(new Node(nextN, nextW));
                }
            }
        }
        return value;
    }
}