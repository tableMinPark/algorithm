import java.io.*;
import java.util.*;

public class p10282 {
    public static class Node implements Comparable<Node>{
        int n;
        int t;

        public Node(int n, int t){
            this.n = n;
            this.t = t;
        }

        @Override
        public int compareTo(Node node){
            return this.t - node.t;
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
            int D = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            List<Node>[] graph = new ArrayList[N + 1];
            int[] value = new int[N + 1];
            
            for (int i = 0; i <= N; i++){
                graph[i] = new ArrayList<>();
                value[i] = Integer.MAX_VALUE;
            }

            for (int i = 0; i < D; i++){
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int S = Integer.parseInt(st.nextToken());
                graph[B].add(new Node(A, S));
            }

            Dijkstra(N, C, graph, value);
            int count = 0;
            int max = 0;
            for (int i = 1; i <= N; i++){
                if (value[i] != Integer.MAX_VALUE){
                    count++;
                    max = Math.max(value[i], max);
                }
            }

            sb.append(count).append(" ").append(max).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static void Dijkstra(int N, int C, List<Node>[] graph, int[] value){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(C, 0));
        value[C] = 0;

        while(!q.isEmpty()){
            Node node = q.poll();

            for (Node next : graph[node.n]){
                int nextT = node.t + next.t;
                if (value[next.n] > nextT){
                    value[next.n] = nextT;
                    q.add(new Node(next.n, nextT));
                }
            }
        }
    }
}
