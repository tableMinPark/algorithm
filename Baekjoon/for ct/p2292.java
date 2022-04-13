import java.io.*;

public class p2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int sum = 1;
        int cnt = 1;
        while(N > sum){
            sum += 6 * cnt++;
        }

        bw.write(String.valueOf(cnt));
        br.close();
        bw.flush();
        bw.close();
    }
}