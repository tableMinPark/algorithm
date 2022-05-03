import java.io.*;

public class s2058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = br.readLine().toCharArray();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) sum += arr[i]-'0';

        bw.write(String.valueOf(sum));
        br.close();
        bw.flush();
        bw.close();
    }
}