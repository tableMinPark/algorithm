import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2644_BFS {
    static int[][] map;
    static boolean[] v;
    static int n;
    static int m;
    static int a;
    static int b;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        v = new boolean[n + 1];

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }
        BFS();

        if (!v[b]) count = -1;
        bw.write(Integer.toString(count));

        bw.flush();
        br.close();
        bw.close();
    }
    public static void BFS(){
        Queue<person> q = new LinkedList<>();
        q.add(new person(a, 0));
        v[a] = true;

        while(!q.isEmpty()){
            person p = q.poll();
            if (p.n == b){
                count = p.count;
                return;
            }
            for (int i = 1; i <= n; i++){
                if (!v[i] && map[p.n][i] == 1){
                    q.add(new person(i, p.count + 1));
                    v[i] = true;
                }
            }
        }
    }
}
class person{
    int n;
    int count;

    person(int n, int count){
        this.n = n;
        this.count = count;
    }
}