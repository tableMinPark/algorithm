import java.io.*;
import java.util.*;

public class p3985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        boolean[] arr = new boolean[L + 1];

        int max = 0, maxIdx = 0;
        int max_r = 0, maxIdx_r = 0;

        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            if (max < K - P + 1){
                max = K - P + 1;
                maxIdx = i;
            }
            int sum = 0;
            for (int j = P; j <= K; j++){
                if (arr[j]) continue;
                arr[j] = true;
                sum++;
            }
            if (max_r < sum){
                max_r = sum;
                maxIdx_r = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxIdx).append("\n").append(maxIdx_r);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}