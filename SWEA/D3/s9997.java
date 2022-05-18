import java.io.*;

public class s9997 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int se = Integer.parseInt(br.readLine());

            int h = se / 30;
            int m = se % 30 * 2;
            
            sb.append("#").append(t).append(" ").append(h).append(" ").append(m).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}