import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int n = 666;
        int c = 1;

        while (N != c){
            n++;
            if (String.valueOf(n).contains("666")) c++;
        }
        bw.write(Integer.toString(n));

        bw.flush();
        br.close();
        bw.close();
    }
}
//"1234".contains("1") -> 1234 라는 문자열안에 1 이라는 문자열이 포함되어있는지 확인하는 함수