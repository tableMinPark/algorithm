import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()) + Integer.parseInt(br.readLine());
        h += m / 60;
        m %= 60;
        if (h >= 24){
            h -= 24;
        }
        bw.write(Integer.toString(h) + " " + Integer.toString(m));
        bw.flush();
        br.close();
        bw.close();
    }
}
