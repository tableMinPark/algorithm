import java.io.*;
import java.util.*;

public class p14391 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] num = new int[N][M];

        for (int i = 0; i < N; i++){
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) num[i][j] = Integer.parseInt(input[j]);
        }

        int answer = 0;

        for (int i = 0; i < (1 << N * M); i++){
            int sum = 0;

            for (int y = 0; y < N; y++){
                int now = 0;
                for (int x = 0; x < M; x++){
                    int idx = y * M + x;

                    if ((i & (1 << idx)) == 0) now = now * 10 + num[y][x];
                    else{
                        sum += now;
                        now = 0;
                    }
                }
                sum += now;
            }

            for (int x = 0; x < M; x++){
                int now = 0;
                for (int y = 0; y < N; y++){
                    int idx = y * M + x;

                    if ((i & (1 << idx)) != 0) now = now * 10 + num[y][x];
                    else{
                        sum += now;
                        now = 0;
                    }
                }
                sum += now;
            }
            answer = answer < sum ? sum : answer;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }
}

/**
1 << k와 모든 경우의 수를 해줄 b를 & 연산하여 각 k번째 자리에 1이 있는지 1이 없는지 구해주면 된다.
자리에 1이 있는 경우 세로이고 0이 있는 경우는 가로이다.
 */