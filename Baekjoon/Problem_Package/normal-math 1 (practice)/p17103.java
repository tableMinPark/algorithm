import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] num = new boolean[1000001];

        for (int i = 2; i <= 1000000; i++){
            if (num[i]) continue;
            for (int j = i + i; j <= 1000000; j += i) num[j] = true;
        }

        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c; i++){
            int count = 0;
            int n = Integer.parseInt(br.readLine());
            
            for (int j = 2; j <= n / 2; j++){
                if (!num[j] && !num[n - j]) count++;
            }
            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
//두 소수의 순서만 다른 것은 같은 파티션이다.
// ex) 12 -> {5, 7}, {7, 5} 같은 파티션이다.