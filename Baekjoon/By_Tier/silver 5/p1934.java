import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A > B){
                int t = A;
                A = B;
                B = t;
            }
            sb.append((A * B) / gcd(A, B)).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
    public static int gcd(int a, int b){
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
}

//최대공약수 and 최소공배수 (재귀함수) -> https://st-lab.tistory.com/154
/*

r = a % b 라고 가정했을 떄 
GCD(a, b) = GCD(b, r) 이다 

1. GCD(581, 322)일 때 r(나머지) = 259이다. 즉, GCD(581, 322) = GCD(322, 259)이다.
2. GCD(322, 259)를 보면 r=63이다. 그러면 GCD(322, 259) = GCD(259, 63)이다.
3. GCD(259, 63)을 보면 r=7이다. 즉, GCD(259, 63) = GCD(63, 7)이다.
4. GCD(63, 7)을 보면 r=0 이다. 그러면 GCD(63, 7) = GCD(7, 0)이다.

결과적으로 나머지가 없다는 것은 공통된 약수로 나누어 떨어진다는 의미이므로 7이 최대공약수가 된다.
*/
