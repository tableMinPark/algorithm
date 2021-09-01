import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1439 {
    static char[] n;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = br.readLine().toCharArray();

        char cn = n[0];

        for (int i = 1; i < n.length; i++){
            if (n[i] != cn){
                cn = n[i];
                if (n[i] != n[0]) count++;
            }
        }
        bw.write(Integer.toString(count));
        bw.flush();
        br.close();
        bw.close();
    }
}
/**
 * 모두 다 같은 문자로 만들기 위해 숫자를 뒤집는 문제이다.
 * 첫번째 문자를 기준으로 연속된 다른 문자가 등장하는 횟수를 세어주면 된다.
 */
