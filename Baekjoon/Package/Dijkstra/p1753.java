import java.io.*;
import java.util.*;

public class p1753{
    static List<List<Node>> graph;
    static int[] costs;


    public static class Node implements Comparable<Node>{
        int n;
        int v;
        public Node(int n, int v){
            this.n = n;
            this.v = v;
        }
        @Override
        public int compareTo(Node n){
            return this.v - n.v;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph.get(p1).add(new Node(p2, value));
        }

        costs = new int[V + 1];
        for (int i = 1; i <= V; i++) costs[i] = Integer.MAX_VALUE;

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++){
            if (costs[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(costs[i]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
    public static void dijkstra(int K){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(K, 0));
        costs[K] = 0;
        
        while(!q.isEmpty()){
            Node node = q.poll();

            for (Node g : graph.get(node.n)){
                if (costs[g.n] > g.v + node.v){
                    costs[g.n] = g.v + node.v;
                    q.add(new Node(g.n, g.v + node.v));
                }
            }
        }
    }
}