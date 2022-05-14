import java.io.*;

public class s1945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int[] n = {2, 3, 5, 7, 11};

            sb.append("#").append(t).append(" ");
            for (int i = 0; i < 5; i++){
                int cnt = 0;
                while(N % n[i] == 0){
                    cnt++;
                    N /= n[i];
                }
                sb.append(cnt).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}