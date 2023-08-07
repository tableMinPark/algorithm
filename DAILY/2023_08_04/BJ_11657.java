import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11657 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static long[] dist;
    static Vertex[] vertexes;
    static class Vertex {
        int a;
        int b;
        int c;
        public Vertex(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        vertexes = new Vertex[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            vertexes[i] = new Vertex(A, B, C);
        }

        // 시작점과 연결된 간선부터 시작해야함
        Arrays.sort(vertexes, (v1, v2) -> v1.a - v2.a);

        // V - 1 번 반복
        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        for (int i = 0; i < N - 1; i++) {
            // 모든 간선을 비교하면서 dist 갱신
            for (Vertex vertex : vertexes) {
                // INF 값이면 갱신하면 안됨다.
                if (dist[vertex.a] == INF) {
                    continue;
                }
                long nextD = dist[vertex.a] + (long) vertex.c;
                dist[vertex.b] = Math.min(dist[vertex.b], nextD);
            }
        }

        // 음수 사이클 체크
        boolean isCycle = false;
        for (Vertex vertex : vertexes) {
            long nextD = dist[vertex.a] + (long) vertex.c;
            if (dist[vertex.a] == INF) {
                continue;
            }
            // 음수 사이클 발생
            if (dist[vertex.b] > nextD) {
                isCycle = true;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (isCycle) {
            sb.append("-1");
        } else {
            for (int i = 2; i <= N; i++) {
                sb.append(dist[i] == INF ? -1 : dist[i]).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
