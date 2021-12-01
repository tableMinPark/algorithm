import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int c = 1;
        int r = 1;
        while (r < n){
            r += 6 * c++;
        }
        bw.write(Integer.toString(c));
        bw.flush();
        br.close();
        bw.close();
    }
}
/*
https://happybplus.tistory.com/115

입력받은 숫자의 층 수를 알면 거리비용을 구할 수 있다.
*/
