import java.io.*;
import java.util.*;

public class s2005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            List<Integer>[] arr = new ArrayList[N];
            for (int i = 0; i < N; i++) arr[i] = new ArrayList<>();

            arr[0].add(1);
            
            for (int i = 1; i < N; i++){
                arr[i].add(1);  
                for (int j = 0; j < i - 1; j++){
                    int sum = arr[i - 1].get(j) + arr[i - 1].get(j + 1);
                    arr[i].add(sum);
                }
                arr[i].add(1);
            }
            sb.append("#").append(t).append("\n");
            for (int i = 0; i < N; i++){
                for (int a : arr[i]) sb.append(a).append(" ");
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}