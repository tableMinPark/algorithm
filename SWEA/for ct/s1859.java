import java.io.*;
import java.util.*;

public class s1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

            long answer = 0;
            long max = arr[N - 1];

            for (int i = N - 2; i >= 0; i--){
                if (arr[i] < max) answer += max - arr[i];
                else max = arr[i];
            }


            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}

// 뒤에서 접근해야함