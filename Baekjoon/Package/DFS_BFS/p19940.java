import java.io.*;
import java.util.*;

public class p19940 {
    static int[] pn = {60, 10, -10, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] dp = new int[61][5];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= 60; i++) Arrays.fill(dp[i], 9);
        q.add(0);

        while(!q.isEmpty()){
            int now = q.poll();

            for (int i = 0; i < 5; i++){
                int next = now + pn[i];
                if (next < 0 || next > 60) continue;

                int[] temp = {dp[now][0], dp[now][1], dp[now][2], dp[now][3], dp[now][4]};
                temp[i]++;

                if (cmp(dp[next], temp)){
                    for (int j = 0; j < 5; j++) dp[next][j] = temp[j];
                    q.add(next);
                }
            }
        }
        
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        for (int testCase = 0; testCase < T; testCase++){
            int N = Integer.parseInt(br.readLine());

            sb.append(N / 60 + dp[N % 60][0]).append(" ");
            N %= 60;

            for (int i = 1; i < 5; i++){
                sb.append(dp[N][i]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean cmp(int[] next, int[] temp){
        int n = 0, t = 0;
        String sn ="", st = "";
        for (int i = 0; i < 5; i++){
            n += next[i];
            t += temp[i];
            sn += String.valueOf(next[i]);
            st += String.valueOf(temp[i]);
        }
        if (n != t) return n > t;
        else return Integer.parseInt(sn) > Integer.parseInt(st);
    }
}