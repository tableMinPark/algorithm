import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int sum = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = M; i <= N; i++){
            int temp = (int) Math.sqrt((float) i);
            if (temp * temp == i){
                if (i < min) min = i;
                sum += i;
            }
        }

        if (min == Integer.MAX_VALUE) sb.append("-1");
        else sb.append(Integer.toString(sum)).append("\n").append(Integer.toString(min));
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
