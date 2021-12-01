import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        int[] s = new int[c];

        for (int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < c; i++) bw.write(Integer.toString(s[i]) + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
