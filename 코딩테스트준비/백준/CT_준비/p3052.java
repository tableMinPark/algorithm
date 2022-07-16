import java.io.*;

public class p3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] v = new int[1001];

        for (int i = 0; i < 10; i++){
            v[Integer.parseInt(br.readLine()) % 42]++;
        }

        int cnt = 0;
        for (int i = 0; i < 1001; i++){
            if (v[i] == 0) continue;
            cnt++;
        }

        bw.write(String.valueOf(cnt));
        br.close();
        bw.flush();
        bw.close();
    }
}