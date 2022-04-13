import java.io.*;
import java.util.*;

public class p2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        int[] arr = new int[1001];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        int mx = 0;
        int my = 0;

        for (int i = 1; i <= 1000; i++){
            if (arr[i] > my) {
                mx = i;
                my = arr[i];
            }
        }

        int max = 0;
        for (int i = 0; i < mx; i++){
            if (arr[i] > max) max = arr[i];
            else arr[i] = max;
        }

        max = 0;
        for (int i = 1000; i > mx; i--){
            if (arr[i] > max) max = arr[i];
            else arr[i] = max;
        }

        int sum = 0;
        for (int i = 0; i <= 1000; i++) sum += arr[i];

        bw.write(String.valueOf(sum));
        br.close();
        bw.flush();
        bw.close();
    }
}