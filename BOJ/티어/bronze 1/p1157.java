import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String w = br.readLine();

        int[] wl = new int[26];

        for (int i = 0; i < w.length(); i++){
            char c = w.charAt(i);
            wl[c >= 'a' ? c - 'a' : c - 'A']++;
        }
        int max = Integer.MIN_VALUE;
        int idx = -2;

        for (int i = 0; i < wl.length; i++){
            if (wl[i] > max){
                max = wl[i];
                idx = i;
            }
        }
        for (int i = 0; i < wl.length; i++) if (wl[i] == max && i != idx) { idx = -2; break; }

        bw.write(Character.toString('A' + idx));
        bw.flush();
        br.close();
        bw.close();
    }
}
