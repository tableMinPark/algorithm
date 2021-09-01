import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class p1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        char[] ts = br.readLine().toCharArray();

        for (int i = 0; i < ts.length; i++) left.push(ts[i]);

        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < c; i++){
            String input = br.readLine();
            char com = input.charAt(0);
            
            if (com == 'P'){
                left.push(input.charAt(2));
            }
            else if (com == 'L'){
                if (!left.isEmpty()) right.push(left.pop());
            }
            else if (com == 'D'){
                if (!right.isEmpty()) left.push(right.pop());
                
            }
            else if (com == 'B'){
                if (!left.isEmpty()) left.pop();
            }
        }
        while (!left.isEmpty()) right.push(left.pop());
        while (!right.isEmpty()) bw.write(right.pop());
        bw.flush();
        br.close();
        bw.close();
    }
}