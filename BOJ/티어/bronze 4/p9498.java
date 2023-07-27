import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int s = Integer.parseInt(br.readLine());

        if (s >= 90){
            bw.write("A");
        }
        else if (s >= 80){
            bw.write("B");
        }
        else if (s >= 70){
            bw.write("C");
        }
        else if (s >= 60){
            bw.write("D");
        }
        else{
            bw.write("F");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
