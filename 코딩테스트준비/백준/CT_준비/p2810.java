import java.io.*;

public class p2810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        char[] map = br.readLine().toCharArray();

        int cnt = 1;

        for (int i = 0; i < N; i++){
            if (map[i] == 'L') i++;
            cnt++;
        }

        bw.write(String.valueOf(cnt < N ? cnt : N));
        br.close();
        bw.flush();
        bw.close();
    }
}