import java.io.*;
import java.util.*;

public class p1162{
    public static class Node implements Comparable<Node>{
        int n;
        long w;
        int c;
        public Node(int n, long w, int c){
            this.n = n;
            this.w = w;
            this.c = c;
        }
        @Override
        public int compareTo(Node n){
            return (int) (this.w - n.w);
        }
    }

    static int N;
    static int M;
    static int K;
    static List<Node>[] graph;
    static long[][] value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        value = new long[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            Arrays.fill(value[i], Long.MAX_VALUE);
        }
        for (int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            graph[S].add(new Node(D, V, 0));
            graph[D].add(new Node(S, V, 0));
        }

        bw.write(String.valueOf(Dijkstra()));
        br.close();
        bw.flush();
        bw.close();
    }

    public static long Dijkstra(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0, 0));
        value[1][0] = 0;
        
        while(!q.isEmpty()){
            Node node = q.poll();

            if (value[node.n][node.c] < node.w) continue;

            for (int i = 0; i < graph[node.n].size(); i++){
                Node next = graph[node.n].get(i);
                long setW = node.w;
                long noSetW = node.w + next.w;

                if (node.c < K && value[next.n][node.c + 1] > setW){
                    value[next.n][node.c + 1] = setW;
                    q.add(new Node(next.n, setW, node.c + 1));
                }
                if (value[next.n][node.c] > noSetW){
                    value[next.n][node.c] = noSetW;
                    q.add(new Node(next.n, noSetW, node.c));
                }
            }
        }
        long answer = Long.MAX_VALUE;

        for (int i = 0; i <= K; i++) answer = Math.min(value[N][i], answer);

        return answer;
    }
}

// 메모리부분 잘 확인하고 문제 진입하자.
// 쓸데없는 반복은 줄이자. (Arrays.fill() : 배열의 값을 초기화해주는 메서드)