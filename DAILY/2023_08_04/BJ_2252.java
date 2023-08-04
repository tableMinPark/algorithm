import java.io.*;
import java.util.*;

public class BJ_2252 {
    static int N, M;
    static int[] dist;
    static List<List<Integer>> graph;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            dist[B]++;
        }

        q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph.get(now)) {
                // 간선 끊어뿌라
                dist[next]--;

                // 끊었는데 0이 되면 대기열에 등록
                if (dist[next] == 0) {
                    q.add(next);
                }
            }

            sb.append(now).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}
