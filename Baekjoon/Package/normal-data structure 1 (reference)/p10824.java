import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p10824{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Long AB = Long.parseLong(st.nextToken() + st.nextToken());
        Long CD = Long.parseLong(st.nextToken() + st.nextToken());
        bw.write(Long.toString(AB + CD));

        bw.flush();
        br.close();
        bw.close();
    }
} 