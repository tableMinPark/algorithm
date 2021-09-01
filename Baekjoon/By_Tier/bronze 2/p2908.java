import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        sb.append(st.nextToken());
        int A = Integer.parseInt(sb.reverse().toString());

        sb = new StringBuilder();
        sb.append(st.nextToken());
        int B = Integer.parseInt(sb.reverse().toString());

        bw.write(Integer.toString(A > B ? A : B));       
        bw.flush();
        br.close();
        bw.close();
    }
}
