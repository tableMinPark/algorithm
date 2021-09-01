import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine()); 
        int b = Integer.parseInt(br.readLine());

        int c = a * (b % 10);
        int d = a * ((b % 100 - b % 10) / 10);
        int e = a * (b / 100);

        bw.write(Integer.toString(c) + "\n");
        bw.write(Integer.toString(d) + "\n");
        bw.write(Integer.toString(e) + "\n");
        bw.write(Integer.toString(c + d * 10 + e * 100) + "\n");


        bw.flush();
        br.close();
        bw.close();
    }
}
