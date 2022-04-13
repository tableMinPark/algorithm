import java.io.*;
import java.util.*;

public class p2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int answer = 0;

        /*
        // BitMask (메모리초과)
        for (Long i = 1L; i < Math.pow(2, N); i++){
            int sum = 0;

            if (Long.bitCount(i) != 3) continue; 
            
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) sum += arr[j];
            }
            if (sum <= M && sum > answer) answer = sum;
        }
        */

        for (int i = 0; i < N - 2; i++){
            for (int j = i + 1; j < N - 1; j++){
                for (int k = j + 1; k < N; k++){
                    int sum = arr[i] + arr[j] + arr[k];

                    if (sum <= M && sum > answer) answer = sum;
                }
            }
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }
}