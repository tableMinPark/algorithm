import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class p1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] nl = br.readLine().toCharArray();
        int[] pow = {4, 2, 1};
        List<Integer> rl = new ArrayList<>();        
        StringBuilder sb = new StringBuilder();
        
        if (nl.length == 1 && nl[0] == '0') sb.append("0");
        else{
            for (int i = 0; i < nl.length; i++){
                long temp = nl[i]-'0';
                for (int j = 0; j < 3; j++){
                    if (temp - pow[j] < 0){
                        if (rl.size() > 0) rl.add(0);
                    }
                    else{
                        rl.add(1);
                        temp -= pow[j];
                    }
                }
            }

            for (int i = 0; i < rl.size(); i++) sb.append(rl.get(i));
        }
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}