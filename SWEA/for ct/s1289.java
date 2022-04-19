import java.io.*;

public class s1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            char[] input = br.readLine().toCharArray();

            int answer = 0;
            int m = 0;

            for (int i = 0; i < input.length; i++){
                if (input[i]-'0' != m){
                    m = input[i]-'0';
                    answer++;
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}