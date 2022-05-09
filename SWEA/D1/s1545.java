import java.io.*;

public class s1545 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = N; i >= 0; i--) sb.append(i).append(" ");

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}