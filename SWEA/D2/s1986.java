import java.io.*;

public class s1986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int sum = 0;
            for (int i = 1; i <= N; i++){
                if (i % 2 == 0) sum -= i;
                else sum += i;
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}