import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class p2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int c = Integer.parseInt(br.readLine());
        int[] n = new int[c];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c; i++) n[i] = Integer.parseInt(br.readLine());
        Arrays.sort(n);
        for (int i = 0; i < c; i++) sb.append(n[i]).append("\n");
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
