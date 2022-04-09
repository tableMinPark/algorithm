import java.io.*;
import java.util.*;

public class p2605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 1; i <= N; i++){
            int n = Integer.parseInt(st.nextToken());
            
            if (n == 0) stack.push(i);
            else{
                for (int j = 0; j < n; j++) stack2.add(stack.pop());
                stack.push(i);
                while(!stack2.isEmpty()) stack.push(stack2.pop());
            }            
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) stack2.add(stack.pop());
        while(!stack2.isEmpty()) sb.append(stack2.pop()).append(" ");

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}