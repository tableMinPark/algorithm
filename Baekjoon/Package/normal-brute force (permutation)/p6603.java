import java.io.*;
import java.util.*;

public class p6603 {
    static int N;
    static int[] S;
    static int[] T;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            if (N == 0) break;

            S = new int[N];      
            T = new int[6];

            for (int i = 0; i < N; i++) S[i] = Integer.parseInt(st.nextToken());

            DFS(0, 0);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int idx, int depth){
        if (depth == 6){
            for (int t : T) sb.append(t).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = idx; i < N; i++){
            T[depth] = S[i];
            DFS(i + 1, depth + 1);
        }
    }
}