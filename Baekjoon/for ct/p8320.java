import java.io.*;

public class p8320 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                if (i * j > n) break;
                else cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        br.close();
        bw.flush();
        bw.close();
    }
}