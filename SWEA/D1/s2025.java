import java.io.*;

public class s2025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 1; i <= N; i++){
            sum += i;
        }

        bw.write(String.valueOf(sum));
        br.close();
        bw.flush();
        bw.close();
    }
}