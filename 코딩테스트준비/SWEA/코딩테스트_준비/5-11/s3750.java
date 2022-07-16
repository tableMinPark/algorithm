import java.io.*;

public class s3750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            String n = br.readLine();

            while(n.length() > 1){
                char[] arr = n.toCharArray();

                int sum = 0;
                for (char a : arr) sum += a-'0';

                n = String.valueOf(sum);
            }

            sb.append("#").append(t).append(" ").append(n).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}