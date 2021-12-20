import java.io.*;
import java.util.*;

public class p2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] shorters = new int[9];
        for (int i = 0; i < 9; i++) shorters[i] = Integer.parseInt(br.readLine());
        Arrays.sort(shorters);
        
        StringBuilder sb = new StringBuilder();

        for (int idx1 = 0; idx1 < 9; idx1++){
            for (int idx2 = 0; idx2 < 9; idx2++){
                if (idx1 == idx2) continue;
                int sum = 0;
                for (int numIdx = 0; numIdx < 9; numIdx++){
                    if (numIdx == idx1 || numIdx == idx2) continue;
                    sum += shorters[numIdx];
                    sb.append(shorters[numIdx]).append("\n");
                }
                if (sum == 100){
                    System.out.println(sb.toString());
                    return;
                }                
                sb = new StringBuilder();
            }
        }
        br.close();
    }
}