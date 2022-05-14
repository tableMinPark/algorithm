import java.io.*;
import java.util.*;

public class s1961 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];

            for (int y = 0; y < N; y++){
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++){
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            List<int[][]> answer = new ArrayList<>();

            for (int i = 0; i < 3; i++){
                map = func(map);
                answer.add(map);
            }

            sb.append("#").append(t).append("\n");
            for (int y = 0; y < N; y++){
                for (int i = 0; i < 3; i++){
                    for (int x = 0; x < N; x++){
                        sb.append(answer.get(i)[y][x]);
                    }                    
                    sb.append(" ");
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static int[][] func(int[][] map){
        int[][] temp = new int[N][N];

        for (int x = 0, yy = 0; x < N; x++, yy++){
            for (int y = N - 1, xx = 0; y >= 0; y--, xx++){
                temp[yy][xx] = map[y][x];
            }
        }
        return temp;
    }
}