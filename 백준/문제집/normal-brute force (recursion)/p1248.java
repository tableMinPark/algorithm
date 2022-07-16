import java.io.*;
import java.util.*;

public class p1248 {
    static int N;
    static char[] input;

    static char[][] map;
    static int[] trace;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();

        map = new char[N][N];
        trace = new int[N];
        
        int idx = 0;
        for (int i = 0; i < N; i++){
            for (int j = i; j < N; j++){
                map[i][j] = input[idx++];
            }
        }
        DFS(0);

        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int depth){
        if (depth == N){            
            sb = new StringBuilder();
            for (int i = 0; i < trace.length; i++) sb.append(trace[i]).append(" ");
            System.out.println(sb.toString());
            System.exit(0);
        }
        for (int i = -10; i <= 10; i++){
            trace[depth] = i;
            if (check(depth)) DFS(depth + 1);
        }
    }

    public static boolean check(int last){
        for (int i = 0; i <= last; i++){
            int sum = 0;
            for (int j = i; j <= last; j++){
                sum += trace[j];
                if (map[i][j] != (sum == 0 ? '0' : (sum > 0 ? '+' : '-'))) return false;
            }
        }
        return true;
    }
}