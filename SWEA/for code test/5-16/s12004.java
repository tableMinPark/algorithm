import java.io.*;

public class s12004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            boolean check = false;
            if (N <= 81){
                for (int i = 1; i <= 9; i++){
                    if (N % i == 0 && N / i < 10 && N / i > 0){
                        check = true;
                        break;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(check ? "Yes" : "No").append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}