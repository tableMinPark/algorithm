import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if (N % 2 == 0) bw.write("CY");
        else bw.write("SK");

        bw.flush();
        br.close();
        bw.close();
    }
}
/**
 * 돌이 1개 혹은 3개를 가져갈 수 있다 = 하나의 턴에 홀수 개만 가져갈 수 있다.
 * 홀수를 홀수번 더하면 홀수이고
 * 홀수를 짝수번 더하면 짝수이기
 * 때문에 N이 홀수 -> SK / 짝수 -> CY
 */