import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null){
            char[] s = input.toCharArray();
            int[] r = new int[4];

            for (int i = 0; i < s.length; i++){
                if (s[i] > 96 && s[i] < 123) r[0]++;
                else if (s[i] > 64 && s[i] < 91) r[1]++;
                else if (s[i] > 47 && s[i] < 58) r[2]++;
                else if (s[i] == ' ') r[3]++;
            }
            for (int i = 0; i < 4; i++) sb.append(r[i] + " ");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
} 