import java.io.*;

public class BJ_2018 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int start = 1, end = 1, sum = 1, count = 1;
        while(end != N) {
            if (sum == N) {
                count++;
                end++;
                sum += end;
            } else if (sum > N) {
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }

        System.out.println(count);
        br.close();
    }
}
