import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int c = 0;

        for (int i = 1; i <= N; i++){
            String n = Integer.toString(i);
            boolean ch = true;

            if (n.length() > 1){
                int t = (n.charAt(1)-'0') - (n.charAt(0)-'0');
                for (int j = 1; j < n.length(); j++){
                    if (n.charAt(j - 1)-'0' + t != n.charAt(j)-'0'){
                        ch = false;
                        break;
                    }
                }
            }
            if (ch) c++;
        }
        bw.write(Integer.toString(c));

        bw.flush();
        br.close();
        bw.close();
    }
}