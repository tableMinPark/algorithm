import java.io.*;

public class s9317 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            char[] ans = br.readLine().toCharArray();
            char[] wrt = br.readLine().toCharArray();

            int answer = 0;
            for (int i = 0; i < N; i++){
                if (ans[i] == wrt[i]) answer++;
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}