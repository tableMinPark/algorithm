import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String w = br.readLine();
        int c = 0;
        boolean s = false;

        for (int i = 0; i < w.length(); i++){
            if (!s && w.charAt(i) != " ".charAt(0)) s = true;
            else if (s && w.charAt(i) == " ".charAt(0)){
                c++;
            }
        }

        if (w.charAt(w.length() - 1) != " ".charAt(0)) c++;
        bw.write(Integer.toString(c));        

        bw.flush();
        br.close();
        bw.close();
    }
}
/*
int c = w.equals(" ") ? 0 : w.trim().split(" ").length;
*/
