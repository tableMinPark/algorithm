import java.io.*;

public class s5603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int sum = 0;

            for (int i = 0; i < N; i++){
                int S = Integer.parseInt(br.readLine());
                arr[i] = S;
                sum += arr[i];
            }

            int answer = 0;

            for (int i = 0; i < N; i++){
                if (arr[i] < sum / N) answer += sum / N - arr[i];
            }
            
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}