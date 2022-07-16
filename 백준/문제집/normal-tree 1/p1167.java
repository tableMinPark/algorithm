import java.io.*;
import java.util.*;

public class p1167 {
    static int N;
    static List<Node>[] graph;
    static boolean[] v;
    static int answer = 0;
    static int farNode;

    public static class Node{
        int c;
        int d;

        public Node(int c, int d){
            this.c = c;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            while(true){
                int c = Integer.parseInt(st.nextToken());
                if (c == -1) break;
                int d = Integer.parseInt(st.nextToken());
                graph[p].add(new Node(c, d));
            }
        }

        v = new boolean[N + 1];
        DFS(1, 0);
        
        v = new boolean[N + 1];
        DFS(farNode, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int parent, int depth){
        v[parent] = true;
        for (Node next : graph[parent]){
            if (!v[next.c]) DFS(next.c, depth + next.d);
        }
        if (answer < depth){
            answer = depth;
            farNode = parent;
        }
        return;
    }
}