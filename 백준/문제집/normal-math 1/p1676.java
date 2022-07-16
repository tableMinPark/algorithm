import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int t = 0, f = 0;

        for (int i = 2; i <= n; i *= 2) t += n / i;
        for (int i = 5; i <= n; i *= 5) f += n / i;

        bw.write(Integer.toString(t < f ? t : f));
        bw.flush();
        br.close();
        bw.close();
    }
}
/**
 * 팩토리얼을 사용하여 계산하면 시간초과로 인해 오답처리된다.
 * 곱해진 2와 5의 갯수를 세어서 0이 몇개인지 판별해야한다. (입력과 동시에 카운트)
 */
