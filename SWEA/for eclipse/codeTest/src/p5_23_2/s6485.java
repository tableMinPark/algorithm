package p5_23_2;

import java.io.*;
import java.util.*;

public class s6485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[5001];

            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                for (int j = A; j <= B; j++) arr[j]++;
            }

            sb.append("#").append(t).append(" ");

            int P = Integer.parseInt(br.readLine());
            for (int i = 0; i < P; i++) {
                int C = Integer.parseInt(br.readLine());
                sb.append(arr[C]).append(" ");
            }
            sb.append("\n");

        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}