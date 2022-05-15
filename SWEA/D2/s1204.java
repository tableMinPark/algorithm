import java.io.*;
import java.util.*;

public class s1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int ti = Integer.parseInt(br.readLine());

            int[] score = new int[101];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++){
                int s = Integer.parseInt(st.nextToken());
                score[s]++;
            }

            int max = 0;
            for (int i = 0; i <= 100; i++) max = Math.max(max, score[i]);

            sb.append("#").append(ti).append(" ");
            for (int i = 100; i >= 0; i--){
                if (score[i] == max) {
                    sb.append(i).append("\n");
                    break;
                }
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}