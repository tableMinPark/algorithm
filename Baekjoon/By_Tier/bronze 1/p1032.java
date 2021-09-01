import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int c = Integer.parseInt(br.readLine());

        char[][] w = new char[c][1];

        for (int i = 0; i < c; i++) {
            String t = br.readLine();
            if (i == 0) w = new char[c][t.length()];
            for (int j = 0; j < t.length(); j++) w[i][j] = t.charAt(j);
        }
        if (c > 1) {    
            for (int i = 0; i < w[0].length; i++){
                for (int j = 1; j < c; j++){
                    if (w[0][i] != w[j][i]){
                        w[0][i] = '?';
                        break;
                    }
                }
            }
        }
        bw.write(w[0]);

        bw.flush();
        br.close();
        bw.close();
    }
}
