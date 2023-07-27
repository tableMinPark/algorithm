import java.io.*;
import java.util.*;

public class p16964 {
    static int N;
    static List<Integer>[] graph;
    static boolean[] v;
    static Queue<Integer> ans = new LinkedList<>();
    static int idx = 1;
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        v = new boolean[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        StringTokenizer st;

        for (int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            graph[B].add(A);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) ans.add(Integer.parseInt(st.nextToken()));

        ans.poll();
        DFS(1);
        
        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int now){
        if (v[now]) return;
        v[now] = true;

        Set<Integer> set = new HashSet<>();

        for (int next : graph[now]){
            if (!v[next]) set.add(next);
        }

        for (int i = 0; i < set.size(); i++){
            int a = ans.poll();
            if (set.contains(a)){
                DFS(a);
                continue;
            }
            answer = 0;
            return;
        }
    }
}