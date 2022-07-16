import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class p1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());

        String[] w = new String[c];

        for (int i = 0; i < c; i++) w[i] = br.readLine();

        StringBuilder sb = new StringBuilder();

        Arrays.sort(w, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if (s1.length() == s2.length()){
                    return s1.compareTo(s2);
                }
                else{
                    return s1.length() - s2.length();
                }
            }
        });
        sb.append(w[0]).append("\n");
        for (int i = 1; i < w.length; i++){
            if (!w[i].equals(w[i - 1])) sb.append(w[i]).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

/*
compareTo -> https://mine-it-record.tistory.com/133
Arrays.sort -> https://ifuwanna.tistory.com/232
*/