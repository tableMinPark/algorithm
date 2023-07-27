import java.io.*;
import java.util.*;

public class p2307{
    public static class Node implements Comparable<Node>{
        int n;
        int v;
        public Node(int n, int v){
            this.n = n;
            this.v = v;
        }
        @Override
        public int compareTo(Node node){
            return this.v - node.v;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B, V));
            graph[B].add(new Node(A, V));
        }
        List<int[]> roadBlock = new ArrayList<>();
        int[] trace = new int[N + 1];
        int min = dijkstra(N, M, graph, trace, new int[]{});

        int idx = N;
        while(idx != 1){
            roadBlock.add(new int[]{trace[idx], idx});
            idx = trace[idx];
        }

        int answer = 0;

        for (int[] rb : roadBlock){
            answer = Math.max(dijkstra(N, M, graph, trace, rb), answer);
        }

        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? -1 : answer - min));
        br.close();
        bw.flush();
        bw.close();
    }

    public static int dijkstra(int N, int M, List<Node>[] graph, int[] trace, int[] rb){
        int[] value = new int[N + 1];
        Arrays.fill(value, Integer.MAX_VALUE);

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0));

        while(!q.isEmpty()){
            Node node = q.poll();
            int nowN = node.n;
            int nowV = node.v;
            
            for (Node next : graph[nowN]){
                int nextN = next.n;
                int nextV = next.v + nowV;
                if (rb.length > 0 && rb[0] == nowN && rb[1] == nextN) continue;

                if (value[nextN] > nextV){
                    trace[nextN] = nowN;
                    value[nextN] = nextV;
                    q.add(new Node(nextN, nextV));
                }
            }
        }
        return value[N];
    }
}