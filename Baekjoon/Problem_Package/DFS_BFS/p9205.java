import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p9205 {
    static int t;
    static int n;
    static boolean[][] v;
    static int[] py = {-1, 1, 0, 0};
    static int[] px = {0, 0, -1, 1};
    static int fx;
    static int fy;
    static point9205 start;
    static point9205 end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        List<point9205> p = new ArrayList<>();

        for (int i = 0; i < t; i++){
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            point9205 location = new point9205(y, x, 0);

            for (int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                p.add(new point9205(y, x, 0));
            }

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            p.add(new point9205(y, x, 0));

            boolean check = true;
            for (int j = 0; j < p.size(); j++){
                if (!BFS(location, p.get(j))){
                    check = false;
                    break;
                }
                location = p.get(j);
            }
            if (check) sb.append("happy");
            else sb.append("sad");
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    public static boolean BFS(point9205 location, point9205 dst){
        int sx = Math.abs(location.x) + Math.abs(dst.x) + 1;
        int sy = Math.abs(location.y) + Math.abs(dst.y) + 1;
        int mx = Math.abs(location.x > dst.x ? dst.x : location.x);
        int my = Math.abs(location.y > dst.y ? dst.y : location.y);

        v = new boolean[sy > sx ? sy : sx][sy > sx ? sy : sx];
        start = new point9205(location.y + my, location.x + mx, 0);
        end = new point9205(dst.y + my, dst.x + mx, 0);

        Queue<point9205> q = new LinkedList<>();
        q.add(start);
        v[start.y][start.x] = true;

        int max = 0;

        while (!q.isEmpty()){
            point9205 temp = q.poll();
            if (max < temp.c) max = temp.c;
            if (temp.x == end.x && temp.y == end.y){
                if ((max - 1) / 1000 > 0) return false;
                else break;
            }

            for (int i = 0; i < 4; i++){
                int nextY = temp.y + py[i];
                int nextX = temp.x + px[i];
                if (nextY < 0 || nextX < 0 || nextY >= sy || nextX >= sx) continue;
                if (v[nextY][nextX]) continue;
                q.add(new point9205(nextY, nextX, temp.c + 1));
                v[nextY][nextX] = true;
            }
        }
        return true;
    }
}
class point9205{
    int y;
    int x;
    int c;

    point9205(int y, int x, int c){
        this.y = y;
        this.x = x;
        this.c = c;
    }
}
