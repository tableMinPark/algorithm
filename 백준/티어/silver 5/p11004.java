import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int idx = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] n = new int[c];

        for (int i = 0; i < c; i++) n[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(n);

        bw.write(Integer.toString(n[idx - 1]));

        bw.flush();
        br.close();
        bw.close();        
    }
}
