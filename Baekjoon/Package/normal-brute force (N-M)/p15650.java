import java.io.*;
import java.util.*;

public class p15650 {
    static int N, M;
    static int[] trace;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trace = new int[M];

        DFS(1, 0);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    public static void DFS(int num, int depth){
        if (depth == M){
            for (int t : trace) sb.append(t).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = num; i <= N; i++){
            trace[depth] = i;
            DFS(i + 1, depth + 1);
        }
    }
}
// 참고한 블로그 > https://st-lab.tistory.com/115