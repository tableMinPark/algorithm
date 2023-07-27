import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1259 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = "";

        StringBuilder sb = new StringBuilder();

        while (!(n = br.readLine()).equals("0")){
            String t = "no";

            if (n.length() == 1) t = "yes";

            else {
                for (int i = 0, j = n.length() - 1; i < n.length() / 2; i++, j--){
                    if (n.charAt(i) != n.charAt(j)){
                        t = "no";
                        break;
                    }
                    else 
                        t = "yes";
                }
            }
            sb.append(t).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
