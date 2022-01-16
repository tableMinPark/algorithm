import java.io.*;
import java.util.*;

public class p10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) set.add(Integer.parseInt(st.nextToken()));


        int M = Integer.parseInt(br.readLine());
        int[] ml = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) ml[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++){
            if (set.contains(ml[i])) sb.append("1").append(" ");
            else sb.append("0").append(" ");            
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}