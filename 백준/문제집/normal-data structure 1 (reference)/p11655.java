import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p11655{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] s = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length; i++){
            if (s[i] > 64){
                s[i] += 13;
                if ((s[i] > 90 && s[i] - 13 < 91) || s[i] > 122) s[i]-= 26;
            }
            sb.append(s[i]);
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
} 