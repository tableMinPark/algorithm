import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class p1935{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        
        char[] s = br.readLine().toCharArray();
        Double[] N = new Double[c];

        for (int i = 0; i < c; i++) N[i] = Double.parseDouble(br.readLine());
        
        Stack<Double> stack = new Stack<>();
        
        for (int i = 0; i < s.length; i++){
            if (s[i]-'A' < 0) {
                Double n1 = stack.pop();
                Double n2 = stack.pop();
                if (s[i] == '*') stack.push(n2 * n1);
                if (s[i] == '+') stack.push(n2 + n1);
                if (s[i] == '-') stack.push(n2 - n1);
                if (s[i] == '/') stack.push(n2 / n1);
            }
            else stack.push(N[s[i]-'A']);
        }
        bw.write(String.format("%.2f", stack.pop()));
        bw.flush();
        br.close();
        bw.close();
    }
} 