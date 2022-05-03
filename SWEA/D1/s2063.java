import java.io.*;
import java.util.*;

public class s2063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());  

        Arrays.sort(arr);

        bw.write(String.valueOf(arr[N / 2]));
        br.close();
        bw.flush();
        bw.close();
    }
}