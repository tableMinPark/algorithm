import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class p11656{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String w = br.readLine();
        String[] r = new String[w.length()];

        for (int i = 0; i < w.length(); i++) r[i] = w.substring(i);
        Arrays.sort(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r.length; i++) sb.append(r[i]).append("\n");
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
} 