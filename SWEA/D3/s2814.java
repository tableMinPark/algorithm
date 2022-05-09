import java.io.*;
import java.util.*;

public class s2814 {
    static List<Integer>[] map;
    static int N, M;
    static boolean[] vd;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) map[i] = new ArrayList<>();

            for (int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                map[A].add(B);
                map[B].add(A);
            }

            answer = 0;
            for (int i = 1; i <= N; i++) {
                vd = new boolean[N + 1];
                DFS(i, 1);
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static void DFS(int n, int d){
        vd[n] = true;
        answer = Math.max(answer, d);

        for (int next : map[n]){
            if (!vd[next]){
                DFS(next, d + 1);
                vd[next] = false;
            }
        }        
    }
}