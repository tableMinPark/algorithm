import java.io.*;
import java.util.*;

public class p16928 {
    static int N, M;
    static Map<Integer, Integer> trap;
    static int answer = Integer.MAX_VALUE;

    public static class Node{
        int n;
        int c;

        public Node(int n, int c){
            this.n = n;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trap = new HashMap<>();
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            trap.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); 
        } 

        BFS(1, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }
    
    public static void BFS(int start, int count){
        Queue<Node> q = new LinkedList<>();
        boolean[] v = new boolean[101];
        q.add(new Node(start, count));

        while(!q.isEmpty()){
            Node now = q.poll();

            if (now.n == 100) answer = Math.min(answer, now.c);

            for (int i = 1; i <= 6; i++){
                int nextN = now.n + i;
                if (trap.get(nextN) != null){
                    nextN = trap.get(nextN);
                }
                if (nextN > 100 || v[nextN]) continue;
                q.add(new Node(nextN, now.c + 1));
                v[nextN] = true;
            }
        }
    }
}