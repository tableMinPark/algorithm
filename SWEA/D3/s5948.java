import java.io.*;
import java.util.*;

public class s5948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[7];

            for (int i = 0; i < 7; i++) arr[i] = Integer.parseInt(st.nextToken());

            List<Integer> answer = new ArrayList<>();

            for (int i = 0; i < 5; i++){
                for(int j = i + 1; j < 6; j++){
                    for (int k = j + 1; k < 7; k++){
                        int sum = arr[i] + arr[j] + arr[k];
                        if (check(sum, answer)) answer.add(sum);
                    }
                }
            }

            Collections.sort(answer, Collections.reverseOrder());

            sb.append("#").append(t).append(" ").append(answer.get(4)).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
    public static boolean check(int sum, List<Integer> answer){
        for (int ans : answer){
            if (ans == sum) return false;
        }
        return true;
    }
}