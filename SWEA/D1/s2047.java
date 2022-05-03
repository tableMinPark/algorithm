import java.io.*;

public class s2047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(br.readLine().toUpperCase());
        br.close();
        bw.flush();
        bw.close();
    }
}