import java.io.*;
import java.util.*;

public class p2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] map = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) map[i] = Integer.parseInt(st.nextToken());

        int answer = Integer.MIN_VALUE;

        for (int i = K; i <= N; i++){
            int sum = 0;
            for (int j = 0; j < K; j++) sum += map[i - j];
            answer = Math.max(answer, sum);
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }
}

// 범위가 -100 ~ 100 이라서 answer의 값을 0이 아닌 Integer.MIN_VALUE 로 잡아주어야 음수도 비교가 가능하다. 