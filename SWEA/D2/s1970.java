import java.io.*;

public class s1970 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int[] div = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            sb.append("#").append(t).append("\n");

            for (int d : div){
                sb.append(N / d).append(" ");
                N %= d;
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}