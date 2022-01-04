import java.io.*;
import java.util.*;

public class p16947 {
    static int N;
    static List<Integer>[] graph;
    static boolean[] v;
    static boolean isCycle = false;
    static Set<Integer> cycle = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static class Node{
        int n;
        int d;

        public Node(int n, int d){
            this.n = n;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            graph[B].add(A);
        }

        for (int i = 1; i <= N; i++){
            v = new boolean[N + 1];
            DFS(i, i, 1);
            if (isCycle) break;
        }

        for (int i = 1; i <= N; i++){
            sb.append(BFS(i)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int now, int start, int depth){
        v[now] = true;

        for (int next : graph[now]){   
            if (v[next]) {
                if (next == start && depth > 2){
                    isCycle = true;
                    for (int j = 1; j <= N; j++){
                        if (v[j]) cycle.add(j);
                    }
                    return;
                }
                continue; 
            }
            DFS(next, start, depth + 1);            
        }

        v[now] = false;
    }

    public static int BFS(int start){
        // 순환선 까지의 거리 찾기
        Queue<Node> q = new LinkedList<>();
        v = new boolean[N + 1];

        q.add(new Node(start, 0));
        v[start] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();

            if (cycle.contains(now.n)) return now.d;

            for (int next : graph[now.n]){
                if (v[next]) continue;
                q.add(new Node(next, now.d + 1));
                v[next] = true;
            }
        }
        return -1;
    }
}

// 2호선과 같은 형태의 노선도가 주어졌을 때 : 순환선은 하나 밖에 없다. (가정)