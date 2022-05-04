import java.io.*;

public class s2027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        sb.append("#++++\n").append("+#+++\n").append("++#++\n").append("+++#+\n").append("++++#\n");
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}