import java.io.*;
import java.util.*;

public class p11725{
    static int N;
    static List<Integer>[] graph;
    static int[] answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        answer = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        StringTokenizer st;        
        for (int i = 2; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            graph[B].add(A);
        }

        BFS();

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) sb.append(answer[i]).append("\n");

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static void BFS(){
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[N + 1];

        q.add(1);
        v[1] = true;

        while(!q.isEmpty()){
            int parent = q.poll();

            for (int child : graph[parent]){
                if (v[child]) continue;
                answer[child] = parent;
                q.add(child);
                v[child] = true;
            }
        }
    }

}