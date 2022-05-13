import java.io.*;
import java.util.*;

public class s7584 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            Queue<Integer> q = new LinkedList<>();
            q.add(0);

            int K = Integer.parseInt(br.readLine());

            while(q.size() < K){
                Stack<Integer> stack = new Stack<>();

                for (int i = 0; i < q.size(); i++){
                    int n = q.poll();
                    q.add(n);
                    stack.push(n);
                }
                q.add(0);
                func(stack, q);                
            }

            for (int i = 1; i < K; i++) q.poll();

            sb.append("#").append(t).append(" ").append(q.poll()).append("\n");            
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static void func(Stack<Integer> stack, Queue<Integer> q){
        Queue<Integer> temp = new LinkedList<>();
        while(!stack.isEmpty()) temp.add(stack.pop());

        for (int i = 0; i < temp.size(); i++) {
            if (temp.poll() == 1) temp.add(0);
            else temp.add(1);
        }
        while(!temp.isEmpty()) q.add(temp.poll());
    }
}

// 다시 (점화식으로 풀어야함)