import java.io.*;
import java.util.*;

public class p10974 {
    static int N;
    static int[] trace;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        trace = new int[N];
        v = new boolean[N + 1];       
        DFS(0);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int depth){
        if (depth == N){
            for (int t : trace) sb.append(t).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++){
            if (v[i]) continue;
            trace[depth] = i;
            v[i] = true;
            DFS(depth + 1);
            v[i] = false;
        }
    }
}