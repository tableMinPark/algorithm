import java.io.*;

public class s7087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[26];

            for (int i = 0; i < N; i++){
                int idx = br.readLine().charAt(0)-'A';
                arr[idx]++;
            }

            int answer = 0;
            for (int i = 0; i < 26; i++){
                if (arr[i] == 0) break;
                answer++;
            }


            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}