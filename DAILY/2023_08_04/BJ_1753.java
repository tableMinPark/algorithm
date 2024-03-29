import java.io.*;
import java.util.*;

public class BJ_1753 {
    static int V, E, K;
    static int[] dist;
    static List<List<Node>> graph;
    static class Node {
        int n;
        int w;
        public Node (int n, int w) {
            this.n = n;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        dijkstra();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> n1.w - n2.w);
        boolean[] v = new boolean[V + 1];
        q.add(new Node(K, 0));

        while(!q.isEmpty()) {
            Node now = q.poll();

            // 정점 기준으로 갱신은 하지만 해당 정점으로 다시 방문해서 두 번이상 갱신하지 않는다.
            // 갱신은 다른 정점에서 갱신할 때만 씀
            // 갱신은 무조건 한번 씩만
            if (v[now.n]) {
                continue;
            }
            v[now.n] = true;

            for (Node next : graph.get(now.n)) {
                int nextD = dist[now.n] + next.w;

                if (dist[next.n] > nextD) {
                    dist[next.n] = nextD;
                    q.add(new Node(next.n, nextD));
                }
            }
        }
    }
}
