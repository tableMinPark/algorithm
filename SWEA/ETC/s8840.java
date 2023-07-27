import java.io.*;

public class s8840 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            long L = (Integer.parseInt(br.readLine()) - 1) / 2;     // n번째항에서 n의 값

            // 1 4 9 16 25 ... (계차수열)
            // 1 + 3 + 5 + 7 + 9 ...

            /*
            3   1
            5   4
            7   9
            9   16
            11  25

            ((L - 1) / 2) * ((L - 1) / 2)
            */

            //int answer = (2 + (L - 1) * 2) / 2 * L;
            long answer = L * L;
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}