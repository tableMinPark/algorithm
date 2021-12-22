import java.io.*;
import java.util.*;

public class p15654 {
    static int N, M;
    static int[] trace;
    static int[] num;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trace = new int[M];
        num = new int[N];
        v = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num);
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
        for (int i = 0; i < N; i++){
            if (v[i]) continue;
            trace[depth] = num[i];
            v[i] = true;
            DFS(depth + 1);
            v[i] = false;
        }
    }
}