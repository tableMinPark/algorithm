import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int s = Integer.parseInt(br.readLine());
        int A = s / 300;
        s %= 300;
        int B = s / 60;
        s %= 60;
        int C = s / 10;
        s %= 10;
        if(s != 0){
            bw.write("-1");
        } else{
            bw.write(Integer.toString(A) + " " + Integer.toString(B) + " " + Integer.toString(C));
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
