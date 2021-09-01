import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p10797 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int d = Integer.parseInt(br.readLine());
        int c = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 5; i++){
            if (Integer.parseInt(st.nextToken()) == d){
                c++;
            }
        }
        bw.write(Integer.toString(c));
        bw.flush();
        br.close();
        bw.close();
    }
    
}
