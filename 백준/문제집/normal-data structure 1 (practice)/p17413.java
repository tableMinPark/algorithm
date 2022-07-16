import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class p17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] s = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean check = false;

        for (int i = 0; i < s.length; i++){
            if (s[i] == '<'){                
                while(!stack.isEmpty()) sb.append(stack.pop());
                check = true;
            }

            if (check){
                sb.append(s[i]);
                if (s[i] == '>') check = false;
            }
            else{
                if (s[i] != ' ') stack.push(s[i]);
                if (s[i] == ' ' || i == s.length - 1) {
                    while(!stack.isEmpty()) sb.append(stack.pop());
                    sb.append(" ");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}