import java.io.*;
import java.util.*;

public class p1389 {
    public static class Node{
        int n;
        int c;
        public Node(int n, int c){
            this.n = n;
            this.c = c;
        }
    }

    static int N;
    static int M;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B, 0));
            graph[B].add(new Node(A, 0));
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++){
            int sum = 0;
            for (int j = 1; j <= N; j++){
                if (j == i) continue;
                sum += BFS(i, j);
            }
            if (min > sum){
                min = sum;
                answer = i;
            }
        }
        
        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();        
    }
    public static int BFS(int start, int end){
        Queue<Node> q = new LinkedList<>();
        boolean[] v = new boolean[N + 1];

        q.add(new Node(start, 0));
        v[start] = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            if (now.n == end) return now.c;

            for (Node next : graph[now.n]){
                if (!v[next.n]){
                    q.add(new Node(next.n, now.c + 1));
                    v[next.n] = true;
                }
            }
        }
        return 0;


    }
}
