import java.io.*;
import java.util.*;

public class p15649 {
    static int N, M;
    static boolean[] v;
    static int[] trace;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        v = new boolean[N + 1];
        trace = new int[M];

        DFS(0);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    public static void DFS(int depth){
        if (depth == M){
            for (int t : trace) sb.append(t).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++){
            if (v[i]) continue;
            v[i] = true;
            trace[depth] = i;
            DFS(depth + 1);
            v[i] = false;
        }
    }
}