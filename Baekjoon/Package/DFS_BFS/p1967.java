import java.io.*;
import java.util.*;

public class p1967 {
    public static class Node{
        int n;
        int v;
        public Node(int n, int v){
            this.n = n;
            this.v = v;
        }
    }
    static int N;
    static List<Node>[] graph;
    static Queue<Node> q;
    static boolean[] v;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        StringTokenizer st;

        for (int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B, V));
            graph[B].add(new Node(A, V));
        }

        int end = BFS(1);
        answer = 0;
        BFS(end);

        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }
    public static int BFS(int n){
        q = new LinkedList<>();
        v = new boolean[N + 1];
        q.add(new Node(n, 0));
        v[n] = true;

        int end = 1;

        while(!q.isEmpty()){
            Node node = q.poll();

            for (Node next : graph[node.n]){
                if (v[next.n]) continue;
                if (answer <  node.v + next.v) {
                    answer = node.v + next.v;
                    end = next.n;
                }
                q.add(new Node(next.n, node.v + next.v));
                v[next.n] = true;
            }
        }
        return end;
    }
}
