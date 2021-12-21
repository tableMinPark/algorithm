import java.io.*;

public class p1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Integer.parseInt(br.readLine());

        long answer = 0;

        for (int i = 1; i <= N; i *= 10) answer += N - i + 1;

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }
}