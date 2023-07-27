import java.io.*;
import java.util.*;

public class p10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        x = (x + t) % (2 * w);
        y = (y + t) % (2 * h);
        x = w - Math.abs(w - x);
        y = h - Math.abs(h - y);

        sb.append(x).append(" ").append(y);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}