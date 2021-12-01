import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class p14502{
    static int N;
    static int M;
    static int[][] map;
    static Queue<P> q;
    static int[] py = {-1, 1, 0, 0};
    static int[] px = {0, 0, -1, 1};
    static int max = 0;

    public static class P{
        int y;
        int x;

        public P(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        q = new LinkedList<>();

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0);

        bw.write(String.valueOf(max));
        br.close();
        bw.flush();
        bw.close();
    }

    public static void DFS(int depth){
        if (depth == 3){
            BFS();
        }
        else{
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if (map[i][j] == 0){
                        map[i][j] = 1;
                        DFS(depth + 1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void BFS(){
        q = new LinkedList<>();
        int[][] virusMap = new int[N][M];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                virusMap[i][j] = map[i][j];
                if (virusMap[i][j] == 2) q.add(new P(i, j));
            }
        }

        while(!q.isEmpty()){
            P p = q.poll();

            for (int i = 0; i < 4; i++){
                int nextY = p.y + py[i];
                int nextX = p.x + px[i];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) continue;

                if (virusMap[nextY][nextX] == 0){
                    virusMap[nextY][nextX] = 2;
                    q.add(new P(nextY, nextX));
                }
            }
        }

        int count = 0;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (virusMap[i][j] == 0) count++;
            }
        }
        max = Math.max(max, count);        
    }
}

//참고블로그 > https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-14502%EB%B2%88-%EC%97%B0%EA%B5%AC%EC%86%8C-%EC%9E%90%EB%B0%94Java