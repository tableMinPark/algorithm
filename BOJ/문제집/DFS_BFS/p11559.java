import java.io.*;
import java.util.*;

public class p11559 {
    static int R = 12;
    static int C = 6;

    static List<Character>[] map;
    static Stack<P> temp;
    static boolean[][] v;
    static Queue<P> q;

    static int[] py = {-1, 1, 0, 0};
    static int[] px = {0, 0, -1, 1};

    public static class P{
        int x;
        int y;
        public P(){}
        public P(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new ArrayList[C];
        for (int i = 0; i < C; i++) map[i] = new ArrayList<>();

        for (int y = 0; y < R; y++){
            char[] temp = br.readLine().toCharArray();
            for (int x = 0; x < C; x++){
                if (temp[x] != '.') map[x].add(temp[x]);
            }
        }

        for (int x = 0; x < C; x++) Collections.reverse(map[x]);

        int answer = 0;

        while(Search()) answer++;

        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }
    public static boolean Search(){
        q = new LinkedList<>();   
        v = new boolean[C][R];     
        temp = new Stack<>();
        boolean flag = false;
        for (int x = 0; x < C; x++){
            for (int y = 0; y < map[x].size(); y++){
                if (!v[x][y]) {
                    q.add(new P(x, y));
                    v[x][y] = true;
                    if (BFS(map[x].get(y))) flag = true;
                }
            }
        }
        while(!temp.isEmpty()){
            P idx = temp.pop();
            map[idx.x].set(idx.y, '.');
        }
        for (int x = 0; x < C; x++){
            for (int y = map[x].size() - 1; y >= 0; y--){
                if (map[x].get(y) == '.') map[x].remove(y);
            }
        }
        return flag;
    }

    public static boolean BFS(char startColor){
        Queue<P> t = new LinkedList<>();
        int count = 0;
        boolean flag = false;

        while(!q.isEmpty()){
            P now = q.poll();
            t.add(new P(now.x, now.y));
            count++;

            for (int i = 0; i < 4; i++){
                int nextX = now.x + px[i];
                int nextY = now.y + py[i];

                if (nextX < 0 || nextX >= C || nextY < 0 || nextY >= map[nextX].size() || v[nextX][nextY]) continue;
                if (map[nextX].get(nextY) != startColor) continue;

                q.add(new P(nextX, nextY));
                v[nextX][nextY] = true;
            }
        }

        if (count > 3){
            flag = true;
            while(!t.isEmpty()) temp.add(t.poll());
        }
        return flag;
    }
}