import java.io.*;

public class s2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            String[] arr = br.readLine().split("");

            int m = Integer.parseInt(arr[4] + arr[5]);
            int d = Integer.parseInt(arr[6] + arr[7]);

            boolean check = false;
            if (m == 2){
                if (d <= 28) check = true;
            } else if (m == 4 || m == 6 || m == 9 || m == 11){
                if (d <= 30) check = true;
            } else if (m > 0 && m < 13) {
                if (d <= 31) check = true;
            }

            String answer = "";
            if (check){
                for (int i = 0; i < 4; i++) answer += arr[i];
                answer += "/" + arr[4] + arr[5] + "/" + arr[6] + arr[7];
            }
            else answer = "-1";

            sb.append('#').append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}