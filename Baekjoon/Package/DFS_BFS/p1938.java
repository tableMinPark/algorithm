import java.io.*;
import java.time.Year;
import java.util.*;

public class p1938 {
    static int N;
    static char[][] map;
    static Queue<P> q;
    static boolean[][] v;
    static int[] py = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] px = {0, 0, -1, 1, -1, 1, 1, -1};
    static int[][] cy = {{0, 0, 0}, {-1, 1, 0}};
    static int[][] cx = {{-1, 1, 0}, {0, 0, 0}};

    public static class P{
        int y;
        int x;
        int d;
        int l;
        public P(int y, int x, int d, int l){
            this.y = y;
            this.x = x;
            this.d = d;
            this.l = l;
        }
    }
    // 0 - 가로
    // 1 - 세로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        q = new LinkedList<>();
        v = new boolean[N][N];

        List<P> start = new ArrayList<>();
        List<P> end = new ArrayList<>();

        for (int y = 0; y < N; y++){
            char[] input = br.readLine().toCharArray();
            for (int x = 0; x < N; x++){
                map[y][x] = input[x];
                if (map[y][x] == 'B') start.add(new P(y, x, 0, 0));
                if (map[y][x] == 'E') end.add(new P(y, x, 0, 0));
            }
        }

        P s = start.get(1);
        P e = end.get(1);

        q.add(new P(s.y, s.x, start.get(0).y == s.y ? 0 : 1, 0));
        v[s.y][s.x] = true;

        int answer = BFS(new P(e.y, e.x, end.get(0).y == e.y ? 0 : 1, 0));

        System.out.println(answer);
        bw.flush();
        br.close();
        bw.close();
    }
    
    public static int BFS(P end){        
        while(!q.isEmpty()){
            P now = q.poll();
            
        }
        return 0;
    }
}