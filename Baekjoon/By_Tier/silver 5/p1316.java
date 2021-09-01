import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        int r = 0;

        for (int i = 0; i < c; i++){
            boolean[] wc = new boolean[26];
            char[] w = br.readLine().toCharArray();
            char pw = 0;

            for (int j = 0; j < w.length; j++){
                if (wc[w[j]-'a'] && pw != w[j]) break;
                else if (j == w.length - 1) r++;

                if (!wc[w[j]-'a']) wc[w[j]-'a'] = true;  
                pw = w[j];
            }
        }
        bw.write(Integer.toString(r));

        bw.flush();
        br.close();
        bw.close();
    }
}
