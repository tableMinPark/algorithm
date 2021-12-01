import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1260 {
    static int N;
    static int M;
    static int V;
    static int[][] l;
    static boolean[] v;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        l = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            l[x][y] = l[y][x] = 1;
        }

        sb = new StringBuilder();
        v = new boolean[N + 1];
        DFS(V);
        
        sb.append("\n");
        v = new boolean[N + 1];
        BFS();

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
    public static void DFS(int idx){
        v[idx] = true;
        sb.append(idx).append(" ");
        for (int i = 1; i <= N; i++) if (!v[i] && l[idx][i] == 1) DFS(i);
    }

    public static void BFS(){
        Queue<Integer> q = new LinkedList<>();

        q.offer(V);
        v[V] = true;
        sb.append(V).append(" ");

        while (!q.isEmpty()){
            int idx = q.poll();

            for (int i = 1; i <= N; i++){
                if (!v[i] && l[idx][i] == 1){
                    q.add(i);
                    v[i] = true;
                    sb.append(i).append(" ");
                }
            }   
        }
    }
}