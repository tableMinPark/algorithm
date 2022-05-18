import java.io.*;
import java.util.*;

public class s6900 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char[][] Narr = new char[N][8];
            int[] Nsc = new int[N];
            char[][] Marr = new char[M][8];

            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                Narr[i] = st.nextToken().toCharArray();
                Nsc[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < M; i++) Marr[i] = br.readLine().toCharArray();

            int answer = 0;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if (check(Narr[i], Marr[j])) answer += Nsc[i];
                }
            }
            
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean check(char[] n, char[] m){
        for (int i = 0; i < 8; i++){
            if ((n[i] != '*') && (n[i] != m[i])) return false;
        }
        return true;
    }
}