import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2439 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = n-1; i >= 0; i--){
            for (int j = 0; j < i; j++) bw.write(" ");
            for (int j = 0; j < n - i; j++) bw.write("*");
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
