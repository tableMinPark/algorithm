import java.io.*;
import java.util.*;

public class p14888 {
    static int N;
    static int[] ns;
    static int[] ca;
    static long max = Integer.MIN_VALUE;
    static long min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        ns = new int[N];
        ca = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) ns[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) ca[i] = Integer.parseInt(st.nextToken());

        DFS(1, ns[0], 0);

        bw.write(new StringBuilder().append(max).append("\n").append(min).toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int idx, long sum, int depth){
        if (depth == N - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        for (int i = idx; i < N; i++){
            for (int j = 0; j < 4; j++){
                if (ca[j] == 0) continue;
                long s = sum;
                if (j == 0) s += ns[i];
                if (j == 1) s -= ns[i];
                if (j == 2) s *= ns[i];
                if (j == 3) {
                    if (sum < 0){
                        s = Math.abs(s);
                        s /= ns[i];
                        s *= -1;
                    }
                    else s /= ns[i];
                }
                ca[j]--;
                DFS(i + 1, s, depth + 1);
                ca[j]++;
            }
        }
    }
}