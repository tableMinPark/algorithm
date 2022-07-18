import java.io.*;
import java.util.*;

public class p15686{
    public static class P{
        int y;
        int x;      
        public P(int y, int x){
            this.y = y;
            this.x = x;
        }  
    }

    static List<P> ch;
    static List<P> ho;
    static boolean[] v;
    static int N;
    static int M;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ch = new ArrayList<>();
        ho = new ArrayList<>();

        for (int y = 0; y < N; y++){
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++){
                int node = Integer.parseInt(st.nextToken());
                if (node == 1) ho.add(new P(y, x));
                if (node == 2) ch.add(new P(y, x));
            }
        }

        answer = Integer.MAX_VALUE;
        v = new boolean[ch.size()];
        DFS(0, 0);

        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }

    public static void DFS(int start, int cnt){
        if (cnt == M){
            int sum = 0;
            for (int i = 0; i < ho.size(); i++){
                int dis = Integer.MAX_VALUE;
                for (int j = 0; j < ch.size(); j++){
                    if (v[j]){
                        int d = Math.abs(ho.get(i).x - ch.get(j).x) + Math.abs(ho.get(i).y - ch.get(j).y);
                        dis = Math.min(dis, d);
                    }
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = start; i < ch.size(); i++){
            v[i] = true;
            DFS(i + 1, cnt + 1);
            v[i] = false;
        }
        
    }
}