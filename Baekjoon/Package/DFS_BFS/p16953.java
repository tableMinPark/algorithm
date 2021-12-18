import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p16953 {
    public static class Node{
        long n;
        int c;
        public Node(long n, int c){
            this.n = n;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(A, 0));

        long answer = -1;

        while(!q.isEmpty()){
            Node now = q.poll();

            if (now.n == B) {
                answer = now.c + 1;
                break;
            }

            if (now.n * 2 <= B) q.add(new Node(now.n * 2, now.c + 1));
            if (now.n * 10 + 1 <= B) q.add(new Node(now.n * 10 + 1, now.c + 1));
        }
        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();        
    }
}
