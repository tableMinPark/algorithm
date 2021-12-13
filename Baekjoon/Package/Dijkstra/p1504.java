import java.io.*;
import java.util.*;

public class p1504 {
    public static class Node implements Comparable<Node>{
        int n;
        int w;

        public Node(int n, int w){
            this.n = n;
            this.w = w;
        }
        @Override
        public int compareTo(Node node){
            return this.w - node.w;
        }
    }

    static int N;
    static int E;
    static List<Node>[] graph;
    static int[] value;
    static int v1;
    static int v2;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        value = new int[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= E; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int v1v2 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int v2v1 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        if (answer != -1) answer = Math.min(v1v2, v2v1);

        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }

    public static int dijkstra(int start, int end){
        for (int i = 1; i <= N; i++) value[i] = Integer.MAX_VALUE;

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        value[start] = 0;

        while(!q.isEmpty()){
            Node node = q.poll();
            int nowN = node.n;
            int nowW = node.w;

            for (Node next : graph[nowN]){
                int nextN = next.n;
                int nextW = next.w + nowW;

                if (value[nextN] > nextW){
                    value[nextN] = nextW;
                    q.add(new Node(nextN, nextW));
                }
            }
        }
        if (value[end] == Integer.MAX_VALUE) answer = -1;

        return value[end];
    }
}
