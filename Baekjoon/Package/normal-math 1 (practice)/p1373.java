import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class p1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> r = new Stack<>();
        char[] nl = br.readLine().toCharArray();
        int sum = 0;
        int idx = 0;
        for (int i = nl.length - 1; i >= 0; i--){
            sum += (nl[i]-'0') * Math.pow(2, idx++);
            if (idx > 2 || i == 0){
                idx = 0;
                r.push(sum);    
                sum = 0;
            }        
        }
        StringBuilder sb = new StringBuilder();
        while (!r.isEmpty()) sb.append(r.pop());
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}