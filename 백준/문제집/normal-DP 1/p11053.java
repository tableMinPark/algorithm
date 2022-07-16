import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[N];

        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }        
        int max = 0;
        for (int i = 0; i < N; i++){
            int min = 0;
            for (int j = 0; j < i; j++){
                if (A[j] < A[i]){
                    if (min < dp[j]) min = dp[j];
                }
            }
            dp[i] = min + 1;
            if (max < dp[i]) max = dp[i];
        }
        bw.write(Integer.toString(max));
        bw.flush();
        br.close();
        bw.close();
    }
}
//https://wootool.tistory.com/96