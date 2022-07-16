import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;

        for (int i = 0; i < c; i++){
            int n = Integer.parseInt(st.nextToken());
            int t = 0;
            for (int j = 1; j <= n; j++) if (n % j == 0) t++;
            if (t == 2) count++;
        }
        bw.write(Integer.toString(count));

        bw.flush();
        br.close();
        bw.close();
    }
}
