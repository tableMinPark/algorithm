import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] N = st.nextToken().toCharArray();
        int B = Integer.parseInt(st.nextToken());
        int sum = 0;

        for (int i = 0, j = N.length - 1; i < N.length; i++, j--){
            int t = N[i]-'0';
            if (t > 9) t -= 7;
            sum += t * Math.pow(B, j);
        }
        bw.write(Integer.toString(sum));
        bw.flush();
        br.close();
        bw.close();
    }
}