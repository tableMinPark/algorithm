import java.io.*;
import java.util.*;


public class p1107 {
    static boolean[] bt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        bt = new boolean[10];

        int min = Integer.MAX_VALUE;
        int minN = 100;
        int answer = 0;
        if (M != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) bt[Integer.parseInt(st.nextToken())] = true;
        }

        if (N != 100){
            for (int i = 0; i <= 1000000; i++){
                if (!check(i)) continue;
                if (min > Math.abs(N - i)){
                    min = Math.abs(N - i);
                    minN = i;
                }
            }
            answer = String.valueOf(minN).length() + Math.abs(N - minN);
            answer = Math.min(answer, Math.abs(N - 100));
        }

        

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }
    public static boolean check(int n){
        char[] check = String.valueOf(n).toCharArray();
        for (int j = 0; j < check.length; j++){
            if (bt[check[j]-'0']) return false;
        }
        return true;
    }
}