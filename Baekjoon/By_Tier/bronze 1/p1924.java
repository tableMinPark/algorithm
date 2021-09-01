import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int ds = 0;

        int[] dc = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};

        if (m > 1) {
            for (int i = 0; i < m - 1; i++) ds += dc[i];
        }
        bw.write(day[(ds + d) % 7]);
        bw.flush();
        br.close();
        bw.close();
    }
}
