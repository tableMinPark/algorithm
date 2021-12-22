import java.io.*;
import java.util.*;

public class p15652 {
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

        DFS(0);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    public static void DFS(int depth){
        if (depth == M){
            if (checkSort()){
                for (int t : trace) sb.append(t).append(" ");
                sb.append("\n");
            }
            return;
        }
        for (int i = 1; i <= N; i++){
            trace[depth] = i;
            DFS(depth + 1);
        }
    }
    public static boolean checkSort(){
        for (int i = 1; i < M; i++){
            if (trace[i - 1] > trace[i]) return false;
        }
        return true;

    }
}