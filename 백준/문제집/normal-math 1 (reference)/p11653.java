import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class p11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[] num = new boolean[10000001];
        List<Integer> prime = new ArrayList<>();

        for (int i = 2; i <= 10000000; i++){
            if (num[i]) continue;
            for (int j = i + i; j <= 10000000; j += i) num[j] = true;
        }
        for (int i = 2; i <= 10000000; i++){
            if (!num[i]) prime.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while (n != 1){
            for (int i = 0; i < prime.size(); i++){
                if (n % prime.get(i) == 0){
                    sb.append(prime.get(i)).append("\n");
                    n /= prime.get(i);
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}