import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        int max = Integer.MIN_VALUE;
        int idx = -1;

        for (int i = 0; i < 9; i++){
            int n = Integer.parseInt(br.readLine());
            if (n > max){
                max = n;
                idx = i + 1;
            }
        }
        bw.write(Integer.toString(max) + "\n" + Integer.toString(idx));
        

        bw.flush();
        br.close();
        bw.close();
    }
}
