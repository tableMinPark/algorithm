import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class p1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] s = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length; i++){
            if (s[i] == '*' || s[i] == '/'){
                if (!stack.isEmpty()) {
                    if (stack.peek() == '*' || stack.peek() == '/'){
                        sb.append(stack.pop());
                    }
                }
                stack.push(s[i]);
            } 
            else if (s[i] == '+' || s[i] == '-'){
                if (!stack.isEmpty()){ 
                    while (!stack.isEmpty()){
                        if (stack.peek() == '(') break;
                        sb.append(stack.pop());
                    }
                }                
                stack.push(s[i]);
            }
            else if (s[i] == '(') stack.push(s[i]);
            else if (s[i] == ')'){
                while (!stack.isEmpty()){
                    if (stack.peek() == '('){
                        stack.pop();
                        break;
                    }
                    sb.append(stack.pop());
                }
            }
            else sb.append(s[i]);
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}