import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c; i++){
            char[] s = br.readLine().toCharArray();

            int count = 0;

            for (int j = 0; j < s.length; j++){
                if (s[j] == '(') count++;
                else if (count == 0 && s[j] == ')'){
                    count = -1;
                    break;
                }
                else if (s[j] == ')') count--;
            }
            if (count == 0) sb.append("YES");
            else  sb.append("NO");
            sb.append("\n");            
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
