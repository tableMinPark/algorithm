import java.io.*;

public class s2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            for (int y = 0; y < N; y++){
                String[] input = br.readLine().split("");
                for (int x = 0; x < N; x++) arr[y][x] = Integer.parseInt(input[x]);
            }

            int sum = 0;
            for (int y = 0, i = 0; y <= N / 2; y++, i++){
                for (int x = N / 2 - i; x <= N / 2 + i; x++){
                    sum += arr[y][x];
                }
            }
            for (int y = N - 1, i = 0; y > N / 2; y--, i++){
                for (int x = N / 2 - i; x <= N / 2 + i; x++){
                    sum += arr[y][x];
                }
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");

        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}