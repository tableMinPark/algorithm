import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1874{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] s = new int[n];
        int idx = 0;
        int num = 1;

        for (int i = 0; i < n; i++) s[i] = Integer.parseInt(br.readLine());

        MyStack stack = new MyStack(n);
        StringBuilder sb = new StringBuilder();

        while (idx < n){
            if (stack.peek() == s[idx]){
                stack.pop();
                sb.append("-\n");
                idx++;
            }
            else{
                if (num > n) {
                    for (int i = idx; i < n; i++){
                        if (s[i] == stack.pop()) sb.append("-\n");
                        else{
                            sb = new StringBuilder().append("NO");
                            break;
                        }
                    }
                    break;
                }
                stack.push(num++);
                sb.append("+\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
class MyStack{
    int idx;
    int[] stack;

    MyStack(int n){
        this.idx = 0;
        this.stack = new int[n];
    }

    public void push(int num){
        this.stack[idx++] = num;
    }

    public int peek(){
        return this.stack[this.idx > 0 ? idx - 1 : idx];
    }

    public int pop(){
        return this.stack[--idx];
    }
}