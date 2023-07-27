import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        String n = br.readLine();
        int s = 0;

        for (int i = 0; i < c; i++) s += n.charAt(i)-'0';
        bw.write(Integer.toString(s));
        
        bw.flush();
        br.close();
        bw.close();
    }    
}
