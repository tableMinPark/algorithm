import java.io.*;

public class s1989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            String str = br.readLine();

            char[] arr = str.toCharArray();

            int answer = 1;

            for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--){
                if (arr[i] != arr[j]) {
                    answer = 0;
                    break;
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