import java.io.*;
import java.util.*;

public class p2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1;
        int max = 1;

        for (int i = 1; i < N; i++){
            if (arr[i - 1] <= arr[i]) cnt++;
            else cnt = 1;
            max = Math.max(max, cnt);
        }

        cnt = 1;
        for (int i = 1; i < N; i++){
            if (arr[i - 1] >= arr[i]) cnt++;
            else cnt = 1;
            max = Math.max(max, cnt);
        }

        bw.write(String.valueOf(max));
        br.close();
        bw.flush();
        bw.close();
    }
}