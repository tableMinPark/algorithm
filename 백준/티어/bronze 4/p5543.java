import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class p5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] b = new int[3];
        int[] d = new int[2];
        for (int i = 0; i < 3; i++){
            b[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < 2; i++){
            d[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(b);
        Arrays.sort(d);
        
        bw.write(Integer.toString(b[0] + d[0] - 50));

        bw.flush();
        br.close();
        bw.close();
    }
}
