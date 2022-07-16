import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] c = new int[9];

        String n = br.readLine();

        int max = 0;

        for (int i = 0; i < n.length(); i++) {
            int idx = n.charAt(i)-'0';
            if (idx == 9) idx = 6;
            c[idx]++;
        }
        int s = c[6];
        c[6] /= 2;
        if (s % 2 != 0) c[6]++;
        for (int i = 0; i < c.length; i++) if (c[i] > max) max = c[i];
        bw.write(Integer.toString(max));
        bw.flush();
        br.close();
        bw.close();
    }
}