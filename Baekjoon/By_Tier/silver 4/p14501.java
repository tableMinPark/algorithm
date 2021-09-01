import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] s = new int[N][2];
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i][0] = Integer.parseInt(st.nextToken());
            s[i][1] = Integer.parseInt(st.nextToken());
        }
        int max = 0;

        int sum = 0;
        for (int i = 0; i < N; i++){
            if (i + s[i][0] - 1 < N) sum += s[i][1];
            i += s[i][0] - 1;
        }
        System.out.println(sum);
        if (sum > max) max = sum;

        sum = 0;
        for (int i = N - 1; i >= 0; i--){
            if (i + s[i][0] - 1 < N){
                sum += s[i][1];
                N -= s[i][0];
                i -= s[i][0] - 1;
            }
        }
        System.out.println(sum);
        if (sum > max) max = sum;

        bw.write(Integer.toString(max));

        bw.flush();
        br.close();
        bw.close();
    }
}
//미해결