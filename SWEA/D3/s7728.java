import java.io.*;

public class s7728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            char[] arr = br.readLine().toCharArray();
            boolean[] v = new boolean[10];

            int answer = 0;
            for (char a : arr){
                if (!v[a-'0']){
                    v[a-'0'] = true;
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