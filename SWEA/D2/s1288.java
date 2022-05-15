import java.io.*;

public class s1288 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int k = 1;
            int cnt = 0;
            boolean[] v = new boolean[10];

            while(cnt < 10){
                int next = N * k++;

                char[] nextArr = String.valueOf(next).toCharArray();
                for (char nextChar : nextArr){
                    int nextInt = nextChar-'0';
                    if (!v[nextInt]){
                        cnt++;
                        v[nextInt] = true;
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(N * (k - 1)).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}