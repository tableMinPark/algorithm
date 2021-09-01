import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class p1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] n = br.readLine().toCharArray();
        Arrays.sort(n);
        StringBuilder sb = new StringBuilder();

        for (int i = n.length - 1; i >= 0; i--) sb.append(n[i]);
        bw.write(sb.toString());
        

        bw.flush();
        br.close();
        bw.close();
    }
}
