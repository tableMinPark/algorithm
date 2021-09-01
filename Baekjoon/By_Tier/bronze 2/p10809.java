import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //알파벳 - 26개
        //ASCII CODE AREA - 97 ~ 122
        String w = br.readLine();

        int[] wp = new int[26];
        for (int i = 0; i < 26; i++) wp[i] = -1;
        for (int i = 0; i < w.length(); i++){
            int idx = w.charAt(i) - 'a';
            if (wp[idx] == -1) wp[idx] = i;
        }
        for (int i = 0; i < 26; i++) bw.write(Integer.toString(wp[i]) + " ");
        bw.flush();
        br.close();
        bw.close();
    }
}
