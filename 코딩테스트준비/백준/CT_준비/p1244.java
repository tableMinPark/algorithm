import java.io.*;
import java.util.*;

public class p1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean[] sw = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++){
            if (Integer.parseInt(st.nextToken()) == 1) sw[i] = true;
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (sex == 1){
                for (int j = 1; j <= N; j++){
                    if (j % num == 0) sw[j] = !sw[j];
                }
            } else{
                sw[num] = !sw[num];
                for (int j = 1; j <= N / 2; j++){
                    int p = num - j;
                    int n = num + j;

                    if (p < 1 || n > N) break;

                    if (sw[p] == sw[n]) {
                        sw[p] = !sw[p];
                        sw[n] = !sw[n];
                    } else break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(sw[i] ? 1 : 0).append(" ");
            if (i % 20 == 0) sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}