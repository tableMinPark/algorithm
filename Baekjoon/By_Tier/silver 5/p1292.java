import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());      
        bw.write(Integer.toString(getSum(B) - getSum(A - 1)));
        bw.flush();
        br.close();
        bw.close();
    }
    public static int getSum(int idx){
        int sum = 0;
        int temp = 0;
        int i = 0;

        while (temp < idx){
            sum += ++i * i;
            temp += i;
        }
        sum -= (temp - idx) * i;
        return sum;
    }
}
