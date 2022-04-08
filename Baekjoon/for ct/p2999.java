import java.io.*;

public class p2999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] str = br.readLine().toCharArray();

        int R = 0;
        int C = 0;
        int N = str.length;

        for (int r = 1; r <= N; r++){
            if (N % r != 0) continue;
            if (N / r < r) break;
            R = r;
            C = N / r;
        }

        char[][] arr = new char[R][C];
        int idx = 0;

        for (int c = 0; c < C; c++){
            for (int r = 0; r < R; r++){
                arr[r][c] = str[idx++];
            }
        }

        StringBuilder sb = new StringBuilder();
        
        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                sb.append(arr[r][c]);
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}