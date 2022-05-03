import java.io.*;

public class s2050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) sb.append(arr[i]-'A' + 1).append(" ");

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}