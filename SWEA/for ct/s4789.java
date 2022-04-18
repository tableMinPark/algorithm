import java.io.*;

public class s4789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            String[] input = br.readLine().split("");

            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) arr[i] = Integer.parseInt(input[i]);

            int answer = 0;
            int sum = 0;
            for (int i = 0; i < arr.length; i++){
                if (sum < i){
                    answer += (i - sum);
                    sum = i;
                }
                sum += arr[i];
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}