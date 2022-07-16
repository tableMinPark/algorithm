import java.io.*;
import java.util.*;

public class p2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0 ; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (i == j) continue;
                int tSum = sum - arr[i] - arr[j];
                if (tSum == 100){
                    for (int k = 0; k < 9; k++){
                        if (k != i && k != j) sb.append(arr[k]).append("\n");
                    }
                    bw.write(sb.toString());
                    bw.flush();
                    return;
                }
            }
        }

        br.close();
        bw.close();
    }
}