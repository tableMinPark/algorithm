import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class p10799_FAST {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int stickCount = 0;

        char[] s = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        stack.push(s[0]);
        for (int i = 1; i < s.length; i++){
            if (s[i] == '(') stack.push(s[i]);
            else if (s[i] == ')'){
                stack.pop();
                if (s[i - 1] == '(') stickCount += stack.size();
                else stickCount++;
            }
        }

        bw.write(Integer.toString(stickCount));
        bw.flush();
        br.close();
        bw.close();
    }
}