import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int n = 64;
        int s = 0;
        int c = 0;

        while (true){
            if (X == 64) {
                c++;
                break;
            }
            else if (s == X) break;
            else{
                n /= 2;
                if (s + n <= X) {
                    s += n;
                    c++;
                }
            }
        }

        bw.write(Integer.toString(c));

        bw.flush();
        br.close();
        bw.close();
    }
}
