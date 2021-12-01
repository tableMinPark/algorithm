import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c; i++){
            long sum = (long) 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nc = Integer.parseInt(st.nextToken());
            int[] nl = new int[nc];
            for (int j = 0; j < nc; j++) nl[j] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < nc; j++){
                for (int k = j + 1; k < nc; k++){
                    int tmp;
                    int a = nl[j];
                    int b = nl[k];
                    if(a < b){
                        tmp = a;
                        a = b;
                        b = tmp;
                    }
                    sum += GCD(a, b);
                }
            }
            sb.append(Long.toString(sum)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    public static long GCD(int a, int b){
        if(b == 0) return (long) a;
        else return GCD(b, a % b);
    }
}
//N=100이고 모든 수가 100만일때 모든 쌍의 최대공약수 합이 int 값의 범위를 초과하는 경우가 발생한다.
//Long 자료형을 사용하여 해결했다.