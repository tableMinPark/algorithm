import java.io.*;
import java.util.*;

public class p10819 {
    static int N;
    static int[] A;
    static int[] T;
    static boolean[] v;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        T = new int[N];
        v = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        DFS(0);
        
        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int depth){
        if (depth == N){
            int sum = 0;
            for (int i = 1; i < N; i++) sum += Math.abs(T[i - 1] - T[i]);
            answer = answer < sum ? sum : answer;
        }
        for (int i = 0; i < N; i++){
            if (v[i]) continue;
            T[depth] = A[i];
            v[i] = true;
            DFS(depth + 1);
            v[i] = false;
        }

    }
}