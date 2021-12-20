import java.io.*;

public class p3085 {
    static int N;
    static int[] py = {-1, 1, 0, 0};
    static int[] px = {0, 0, -1, 1};
    static char[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for (int y = 0; y < N; y++) map[y] = br.readLine().toCharArray();


        for (int y = 0; y < N; y++){
            for (int x = 0; x < N - 1; x++){
                int nextY = y;
                int nextX = x + 1;
                if (map[y][x] == map[nextY][nextX]) continue;
                char temp = map[y][x];
                map[y][x] = map[nextY][nextX];
                map[nextY][nextX] = temp;
                Search();           
                temp = map[y][x];
                map[y][x] = map[nextY][nextX];
                map[nextY][nextX] = temp;
            }
        }
        for (int x = 0; x < N; x++){
            for (int y = 0; y < N - 1; y++){
                int nextY = y + 1;
                int nextX = x;
                if (map[y][x] == map[nextY][nextX]) continue;
                char temp = map[y][x];
                map[y][x] = map[nextY][nextX];
                map[nextY][nextX] = temp;
                Search();          
                temp = map[y][x];
                map[y][x] = map[nextY][nextX];
                map[nextY][nextX] = temp;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }
    public static void Search(){
        for (int x = 0; x < N; x++){
            int count = 1;
            for (int y = 0; y < N - 1; y++){
                int nextY = y + 1;
                int nextX = x;
                
                if (map[y][x] == map[nextY][nextX]) count++;
                else count = 1;                
                answer = Math.max(answer, count);
            }
        }
        for (int y = 0; y < N; y++){
            int count = 1;
            for (int x = 0; x < N - 1; x++){
                int nextY = y;
                int nextX = x + 1;
                
                if (map[y][x] == map[nextY][nextX]) count++;
                else count = 1;
                answer = Math.max(answer, count);
            }
            
        }
    }
}