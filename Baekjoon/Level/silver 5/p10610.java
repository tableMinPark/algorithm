import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class p10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] n = br.readLine().toCharArray();

        int sum = 0;

        for (int i = 0; i < n.length; i++) sum += n[i]-'0';

        StringBuilder sb = new StringBuilder();
        Arrays.sort(n);
        
        if (sum % 3 == 0 && n[0] == '0'){
            for (int i = n.length - 1; i >= 0; i--) sb.append(n[i]);
        }
        else sb.append("-1");
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}

/*

3의 배수조건 -> 각 자리 숫자 합이 3의 배수
10의배수조건 -> 일의자리가 0인 수

위의 두개의 조건을 만족하고 내림차순 정렬하면 30의 배수인 최대값이 된다.

*/