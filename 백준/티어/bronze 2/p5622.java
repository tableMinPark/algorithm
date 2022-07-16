import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int t = 0;

        for (int i = 0; i < s.length(); i++){
            int n = s.charAt(i)-'A';
            if (n < 16) t += n / 3;
            else if (n < 19) t += 5;
            else if (n < 22) t += 6;
            else if (n < 26) t+= 7;
            t += 3;
        }
        bw.write(Integer.toString(t));

        bw.flush();
        br.close();
        bw.close();
    }
}
