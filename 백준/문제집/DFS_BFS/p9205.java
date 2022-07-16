import java.io.*;
import java.util.*;

public class p9205 {
    public static class P{
        int x;
        int y;

        public P(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static P[] point;
    static List<ArrayList<Integer>> graph;

    static Queue<Integer> q;
    static boolean[] v;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        sb = new StringBuilder();

        for (int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());

            point = new P[N + 2];
            
            for (int j = 0; j < N + 2; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                point[j] = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            graph = new ArrayList<>();
            for (int j = 0; j < point.length; j++) graph.add(new ArrayList<>());

            for (int j = 0; j < point.length; j++){
                for (int k = 0; k < point.length; k++){                    
                    if (Math.abs(point[j].x - point[k].x) + Math.abs(point[j].y - point[k].y) <= 1000){
                        graph.get(j).add(k);
                        graph.get(k).add(j);
                    }   
                }             
            }

            q = new LinkedList<>();
            v = new boolean[point.length];

            q.add(0);
            v[0] = true;

            sb.append(BFS(N) ? "happy" : "sad").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    public static boolean BFS(int N){
        while(!q.isEmpty()){
            int idx = q.poll();

            if (idx == N + 1) return true;

            for (int g : graph.get(idx)){
                if (!v[g]){
                    v[g] = true;
                    q.add(g);
                }
            }
        }
        return false;
    }
}
//참고한 블로그 > https://steady-coding.tistory.com/97
//이동가능한 정점(편의점) 2개를 양방향 그래프로 이어서 그래프 생성
//너비탐색을 통해 시점부터 종점까지 도달가능한지 파악