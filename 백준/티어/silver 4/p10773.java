import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        int[] s = new int[K];
        int idx = 0;
        int sum = 0;

        for (int i = 0; i < K; i++){
            int n = Integer.parseInt(br.readLine());
            if (n == 0){
                sum -= s[--idx];
            }
            else{
                sum += n;
                s[idx++] = n;
            } 
        }
        bw.write(Integer.toString(sum));

        bw.flush();
        br.close();
        bw.close();
    }
}
