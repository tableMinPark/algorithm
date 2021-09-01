import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nl = new int[N];
        for (int i = 0; i < N; i++){
            nl[i] = S - Integer.parseInt(st.nextToken());
            if (nl[i] < 0) nl[i] *= -1;
        }
        int g;

        if (N == 1) g = nl[0];
        else{
            int tmp;
            int a = nl[0];
            int b = nl[1];
            if (a < b){
                tmp = a;
                a = b;
                b = tmp;
            }
            g = GCD(a, b);

            for (int i = 2; i < nl.length; i++){
                b = nl[i];
                if (g < b){
                    tmp = g;
                    g = b;
                    b = tmp;
                }
                g = GCD(g, b);
            }
        }
        bw.write(Integer.toString(g));
        bw.flush();
        br.close();
        bw.close();
    }
    public static int GCD(int a, int b){
        if (b == 0) return a;
        else return GCD(b, a % b);
    }
}