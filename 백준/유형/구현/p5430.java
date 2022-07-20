import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class p5430{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            char[] p = br.readLine().toCharArray();
            
            int n = Integer.parseInt(br.readLine());
            String[] input;
            input = br.readLine().replace("[", "").replace("]", "").split(",");
            
            Deque<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) q.add(Integer.parseInt(input[i]));

            boolean head = false;   // false : front - true : rear
            boolean error = false;

            for (int i = 0; i < p.length; i++){
                if (p[i] == 'R'){
                    head = !head;
                } else if (p[i] == 'D'){
                    if (q.isEmpty()){
                        error = true;
                        break;
                    }
                    if (!head) q.pollFirst();
                    else q.pollLast();
                }
            }

            if (error){
                sb.append("error\n");
            } else {
                sb.append("[");
                while(!q.isEmpty()){
                    if (!head) sb.append(q.pollFirst());
                    else sb.append(q.pollLast());
                    if (q.size() != 0) sb.append(",");
                }
                sb.append("]\n");
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}

