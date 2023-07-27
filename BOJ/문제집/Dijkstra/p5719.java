import java.io.*;
import java.util.*;

public class p5719{
    public static class Node implements Comparable<Node>{
        int n;
        int w;
        public Node(int n, int w){
            this.n = n;
            this.w = w;
        }
        @Override
        public int compareTo(Node n){
            return this.w - n.w;
        }
    }

    static int N;
    static int M;
    static int S;
    static int D;

    static List<Node>[] graph;
    static List<Integer>[] trace;
    static boolean[][] check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        
        while (true){
            st = new StringTokenizer(br.readLine());        
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            
            graph = new ArrayList[N];
            trace = new ArrayList[N];

            for (int i = 0; i < N; i++){
                graph[i] = new ArrayList<>();
                trace[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                graph[U].add(new Node(V, P));
            }
            check = new boolean[N][N];

            dijkstra();
            backTracking(S, D);
            int answer = dijkstra();

            sb.append(answer == Integer.MAX_VALUE ? -1 : answer).append("\n");
        }
        
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static void backTracking(int S, int node) {
		if (node == S)
			return;

		for (int n : trace[node]) {

			if (!check[n][node]) {
				check[n][node] = true;
				backTracking(S, n);
			}
		}
	}

    public static int dijkstra(){
        int[] value = new int[N];

        for (int i = 0; i < N; i++) value[i] = Integer.MAX_VALUE;

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(S, 0));
        value[S] = 0;

        while(!q.isEmpty()){
            Node now = q.poll();
            int nowN = now.n;
            int nowW = now.w;

            for (Node next : graph[nowN]){
                int nextN = next.n;
                int nextW = next.w + nowW;
                
                if (check[nowN][nextN]) continue;

                if (value[nextN] == nextW) trace[nextN].add(nowN);

                else if (value[nextN] > nextW){
                    trace[nextN].clear();
                    trace[nextN].add(nowN);
                    value[nextN] = nextW;
                    q.add(new Node(nextN, nextW));
                }
            }
        }

        return value[D];
    }
}

//참고한 블로그 > https://lotuslee.tistory.com/137