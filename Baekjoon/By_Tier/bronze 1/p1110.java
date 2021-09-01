import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();

        if (Integer.parseInt(N) < 10) N += '0';

        String tN = N;
        int c = 0;        
        while (true){
            c++;            
            int A = tN.charAt(0)-'0';
            int B = tN.charAt(1)-'0';
            tN = String.valueOf(A + B);
            tN = String.valueOf(B) + tN.charAt(tN.length() - 1);
            if (tN.equals(N)){
                break;
            }
        }
        bw.write(Integer.toString(c));
        

        bw.flush();
        br.close();
        bw.close();
    }
}