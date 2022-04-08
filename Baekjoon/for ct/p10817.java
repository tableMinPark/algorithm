import java.io.*;
import java.util.*;

public class p10817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] answer = {A, B, C};
        Arrays.sort(answer);

        bw.write(String.valueOf(answer[1]));
        br.close();
        bw.flush();
        bw.close();
    }
}