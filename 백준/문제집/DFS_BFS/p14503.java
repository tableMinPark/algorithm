import java.io.*;
import java.util.*;

public class p14503 {
    static int N;
    static int[][] map;
    static boolean[][] v;
    static Queue<P> q;

    static List<P> f;

    static int[] py = {-1, 1, 0, 0};
    static int[] px = {0, 0, -1, 1};

    public static class P implements Comparable<P>{
        int y;
        int x;
        int t;
        int h;
        public P(int y, int x, int t, int h){
            this.y = y;
            this.x = x;
            this.t = t;
            this.h = h;
        }
        
        @Override
        public int compareTo(P p){
            if (this.t == p.t){
                if (this.y == p.y){
                    return this.x - p.x;
                }
                else{
                    return this.y - p.y;
                }
            }
            else{
                return this.t - p.t;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int sy = 0;
        int sx = 0;

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9){
                    map[i][j] = 0;
                    sy = i;
                    sx = j;
                }
            }
        }

        int answer = 0;
        int eatCount = 0;
        P now = new P(sy, sx, 0, 2);

        while (true){
            BFS(now);
            if (f.isEmpty()) {
                answer = now.t;
                break;
            }
            Collections.sort(f);
            now = f.get(0);
            map[now.y][now.x] = 0;
            eatCount++;
            
            if (eatCount >= now.h){
                now.h++;
                eatCount = 0;
            }
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }   
    public static void BFS(P start){
        q = new LinkedList<>();
        v = new boolean[N][N];
        f = new ArrayList<>();

        q.add(start);
        v[start.y][start.x] = true;

        while(!q.isEmpty()){
            P p = q.poll();
            
            for (int i = 0; i < 4; i++){
                int nextY = p.y + py[i];
                int nextX = p.x + px[i];
                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N || v[nextY][nextX]) continue;
                if (map[nextY][nextX] <= p.h){
                    q.add(new P(nextY, nextX, p.t + 1, p.h));
                    v[nextY][nextX] = true;
                }
                if (map[nextY][nextX] < p.h && map[nextY][nextX] != 0) f.add(new P(nextY, nextX, p.t + 1, p.h));
            }
        }
    }
}

//빠른시간에 풀었지만 상어의 처음위치를 map에서 0으로 초기화하지 않고 9로 그대로 두었기 때문에 시간이 걸렸던 문제