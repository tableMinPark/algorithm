import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        double max = 0;
        int[] n = new int[c];
        double sum = 0;

        for (int i = 0; i < c; i++) {
            n[i] = Integer.parseInt(st.nextToken());
            if (max < n[i]) max = n[i];
        }
        for (int i = 0; i < c; i++) sum += n[i] / max * 100;
        bw.write(Double.toString(sum / c));

        bw.flush();
        br.close();
        bw.close();
    }
}
