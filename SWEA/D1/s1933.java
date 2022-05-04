import java.io.*;

public class s1933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++){
            if (N % i == 0) sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}