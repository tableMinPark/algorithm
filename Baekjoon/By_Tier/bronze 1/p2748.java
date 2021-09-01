import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class p2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long a = 0;
        long b = 1;
        long r = n == 0 ? 0 : 1;

        for (int i = 1; i < n; i++){
            r = a + b;
            a = b;
            b = r;
        }
        bw.write(Long.toString(r));

        bw.flush();
        br.close();
        bw.close();
    }
}
