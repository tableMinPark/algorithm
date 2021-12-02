import java.io.*;
import java.util.*;

public class p13913{
    public static class P{
        int point;
        int time;
        List<Integer> route;

        public P(int point, int time){
            this.point = point;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        if (N == K){
            sb.append(0).append("\n");
            sb.append(N).append("\n");
        }
        else{
            int[] parents = new int[100001];
            boolean[] v = new boolean[100001];

            Queue<P> q = new LinkedList<>();
            q.add(new P(N, 0));
            v[N] = true;

            while (!q.isEmpty()){
                P p = q.poll();

                int n1 = p.point - 1;
                int n2 = p.point + 1;
                int n3 = p.point * 2;
                                
                if (n1 >= 0 && !v[n1]){
                    parents[n1] = p.point;
                    q.add(new P(n1, p.time + 1));
                    v[n1] = true;
                }
                if (n2 <= 100000 && !v[n2]){
                    parents[n2] = p.point;
                    q.add(new P(n2, p.time + 1));
                    v[n2] = true;
                }
                if (n3 <= 100000 && !v[n3]){
                    parents[n3] = p.point;
                    q.add(new P(n3, p.time + 1));
                    v[n3] = true;
                }
                if (n1 == K || n2 == K || n3 == K){
                    sb.append(p.time + 1).append("\n");
                    break;
                }
            }

            Stack<Integer> s = new Stack<>();
            int idx = K;

            while(idx != N){
                s.push(idx);
                idx = parents[idx];
            }
            s.push(idx);

            while(!s.isEmpty()) sb.append(s.pop()).append(" ");
        }
        
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}