import java.io.*;
import java.util.*;

public class p14889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] numbers = new int[N][N];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) numbers[i][j] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i < (1 << N); i++){
            int c = 0;
            for (int j = 0; j < N; j++){
                if ((i & (1 << j)) == 0) c++;
            }
            if (c != N / 2) continue;

            List<Integer> t1 = new ArrayList<>();
            List<Integer> t2 = new ArrayList<>();
            
            for (int j = 0; j < N; j++){
                if ((i & (1 << j)) == 0) t1.add(j);
                else t2.add(j);
            }

            int s1 = 0, s2 = 0;

            for (int j = 0; j < (N / 2); j++){
                for (int k = 0; k < (N / 2); k++){
                    if (j == k) continue;
                    s1 += numbers[t1.get(j)][t1.get(k)];
                    s2 += numbers[t2.get(j)][t2.get(k)];
                }
            }

            int diff = Math.abs(s1 - s2);

            if (answer > diff) answer = diff;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }
}