import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String r = String.valueOf(A * B * C);
        int[] c = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < r.length(); i++) c[r.charAt(i)-'0']++;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) sb.append(c[i]).append("\n");
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
    
}
