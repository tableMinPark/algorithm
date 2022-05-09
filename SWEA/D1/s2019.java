import java.io.*;

public class s2019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int sum = 1;
        for (int i = 0; i < N; i++){
            sb.append(sum).append(" ");
            sum *= 2;
        }
        sb.append(sum);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}