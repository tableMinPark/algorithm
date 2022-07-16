import java.io.*;
import java.util.*;

public class p2564 {
    static int[] map;
    static int Y;
    static int X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        map = new int[N + 1];
        
        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            map[i] = point(direction, location);
        }

        st = new StringTokenizer(br.readLine());
        map[0] = point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int answer = 0;

        for (int i = 1; i <= N; i++){
            int A = Math.max(map[0], map[i]);
            int B = Math.min(map[0], map[i]);
            answer += Math.min(A - B, 2 * (Y + X) - A + B);
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }

    public static int point(int direction, int location){
        if (direction == 1){
            return location;
        } else if (direction == 2){
            return 2 * Y + X - location;
        } else if (direction == 3){
            return 2 * Y + 2 * X - location;
        } else if (direction == 4){
            return Y + location;
        } else{
            return 0;
        }
    }
}