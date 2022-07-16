import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] w = new char[5][15];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++){
            String t = br.readLine();
            for (int j = 0; j < t.length(); j++) w[i][j] = t.charAt(j);
        }

        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 5; j++){
                if (w[j][i] != 0) sb.append(w[j][i]);
            }
        }
        bw.write(sb.toString().trim());

        bw.flush();
        br.close();
        bw.close();
    }
}
