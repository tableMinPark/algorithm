import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long S = Long.parseLong(br.readLine());
        long n = 0;
        long sum = 0;
        
        while (S >= sum){
            sum += ++n;
        }
        bw.write(Long.toString(sum == S ? n : n - 1));
        bw.flush();
        br.close();
        bw.close();
    }
}

/*
이분탐색으로 다시풀어볼것!
 */