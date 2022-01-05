import java.io.*;
import java.util.*;

public class p16940 {
    static int N;
    static List<Integer>[] graph;
    static Queue<Integer> ans = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            graph[B].add(A);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            ans.add(Integer.parseInt(st.nextToken()));
            Collections.sort(graph[i]);
        }
    
        bw.write(String.valueOf(BFS()));
        bw.flush();
        br.close();
        bw.close();
    }

    public static int BFS(){
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[N + 1];

        q.add(1);
        v[1] = true;
        ans.poll();

        while(!q.isEmpty()){
            int now = q.poll();

            Set<Integer> set = new HashSet<>();
            for (int next : graph[now]){
                if (!v[next]) set.add(next);
            }

            for (int i = 0; i < set.size(); i++){
                int a = ans.poll();
                if (set.contains(a)){
                    q.add(a);
                    v[a] = true;
                    continue;
                }
                return 0;
            }
        }
        return 1;
    }
}