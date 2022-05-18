import java.io.*;
import java.util.*;

public class s10505 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int avg = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                avg += arr[i];
            }
            avg /= N;

            int answer = 0;
            for (int a : arr){
                if (a <= avg) answer++;
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}