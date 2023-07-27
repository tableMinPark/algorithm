import java.io.*;
import java.util.*;

public class p15665 {
    static int N, M;
    static int[] num;
    static int[] trace;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        trace = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num);

        DFS(0, 0);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int idx, int depth){
        if (depth == M){
            for (int t : trace) sb.append(t).append(" ");
            sb.append("\n");
            return;
        }

        int past = -1;
        for (int i = 0; i < N; i++){
            int now = num[i];
            if (past == now) continue;
            past = now;
            trace[depth] = num[i];
            DFS(i + 1, depth + 1);
        }
    }
}