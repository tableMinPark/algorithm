import java.io.*;
import java.util.*;

public class BJ_1516 {
    static int N;
    static Queue<Integer> q;
    static List<List<Integer>> graph;
    static int[] dist, times, answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        q = new ArrayDeque<>();
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        dist = new int[N + 1];
        times = new int[N + 1];
        for (int now = 1; now <= N; now++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            times[now] = time;

            int count = 0;
            while(true) {
                int next = Integer.parseInt(st.nextToken());

                if (next == -1) {
                    break;
                }

                graph.get(next).add(now);
                count++;
            }
            dist[now] = count;
            if (dist[now] == 0) {
                q.add(now);
            }
        }

        answer = new int[N + 1];
        while(!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph.get(now)) {
                // 간선 끊기
                dist[next]--;

                if (dist[next] == 0) {
                    q.add(next);
                }
                answer[next] = Math.max(answer[next], answer[now] + times[now]);
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i] + times[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
