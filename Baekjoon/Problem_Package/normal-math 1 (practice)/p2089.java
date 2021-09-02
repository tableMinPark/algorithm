import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();
        if (n == 0) sb.append("0");
        else{
            while (n != 0){
                if ((n - 1) % (-2) == 0){
                    n = (n - 1) / (-2);
                    sb.append("1");
                    continue;
                }
                n /= (-2);
                sb.append("0");
            }
        }
        bw.write(sb.reverse().toString());
        bw.flush();
        br.close();
        bw.close();
    }
}