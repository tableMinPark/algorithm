import java.io.*;
import java.util.*;

public class p2529 {
    static int K;
    static boolean[] v;
    static int[] trace;
    static char[] map;

    static long max = 0, min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());

        v = new boolean[10];
        trace = new int[K + 1];
        map = new char[K];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) map[i] = st.nextToken().charAt(0);
        
        DFS(0);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%0" + (K + 1) + "d", max)).append("\n");
        sb.append(String.format("%0" + (K + 1) + "d", min)).append("\n");

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int depth){
        if (depth == K + 1){
            if (check()){
                long num = 0;
                for (int t : trace) num = num * 10 + t;
                
                max = Math.max(max, num);
                min = Math.min(min, num); 
            }
            return;
        }

        for (int i = 0; i < 10; i++){
            if (v[i]) continue;
            trace[depth] = i;
            v[i] = true;
            DFS(depth + 1);
            v[i] = false;
        }
    }
    public static boolean check(){
        for (int i = 0; i < K; i++){
            if (map[i] == '<'){
                if (trace[i] > trace[i + 1]) return false;
            }            
            if (map[i] == '>'){
                if (trace[i] < trace[i + 1]) return false;
            }
        }
        return true;
    }
}