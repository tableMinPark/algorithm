import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p10808{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] w = br.readLine().toCharArray();
        int[] a = new int[26];

        for (int i = 0; i < w.length; i++) a[w[i]-'a']++;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) sb.append(a[i] + " ");
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
} 