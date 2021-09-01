import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = Integer.MAX_VALUE;

        if (M == 1) M++;
        for (int i = M; i <= N; i++){
            boolean check = true;
            for (int j = 2; j < i; j++){
                if (i % j == 0){
                    check = false;
                    break;
                }
            }
            if (check){
                sum += i;
                min = min > i ? i : min;
            }
        }

        StringBuilder sb = new StringBuilder();

        if (sum == 0) sb.append("-1");
        else{
            sb.append(sum).append("\n").append(min);
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
