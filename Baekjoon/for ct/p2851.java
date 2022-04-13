import java.io.*;

public class p2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) arr[i] = Integer.parseInt(br.readLine());

        int answer = 0;
        int sum = 0;
        for (int i = 0; i < 10; i++){
            int temp = sum + arr[i];

            if (Math.abs(100 - sum) >= Math.abs(100 - temp)) {
                answer = temp;
                sum = temp;
            }
            if (temp > 100) break;
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }
}