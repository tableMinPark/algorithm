import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] w = br.readLine().toCharArray();

        String r = "1";

        for (int i = 0, j = w.length - 1; i < w.length / 2; i++, j--){
            if (w[i] != w[j]){
                r = "0";
                break;
            }
        }
        bw.write(r);

        bw.flush();
        br.close();
        bw.close();
    }
}
