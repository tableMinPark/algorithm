import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long r = Long.parseLong(st.nextToken());
        
        int t = two(n) - two(n - r) - two(r);
        int f = five(n) - five(n - r) - five(r);

        bw.write(Integer.toString(t > f ? f : t));
        bw.flush();
        br.close();
        bw.close();
    }
    public static int two(long num){
        int c = 0;
        for (long i = 2; i <= num; i *= 2){
            c += num / i;
        }
        return c;
    }
    public static int five(long num){
        int c = 0;
        for (long i = 5; i <= num; i *= 5){
            c += num / i;
        } 
        return c;
    }
}

/**
 * two & five 함수의 for문에서 i *= 2 와 i *= 5 에서 오버플로가 발생하여 / by zero 런타임에러가 발생
 * long으로 변경하여 문제해결
 */