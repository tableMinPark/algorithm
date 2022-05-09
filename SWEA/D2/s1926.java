import java.io.*;

public class s1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++){
            char[] arr = String.valueOf(i).toCharArray();

            int c = 0;
            for (char a : arr){
                for (int j = 3; j <= 9; j += 3){
                    if (a-'0' == j){
                        sb.append("-");
                        c++;
                    }
                }
            }

            if (c == 0) sb.append(i);
            sb.append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}