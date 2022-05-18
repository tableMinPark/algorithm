import java.io.*;
import java.util.*;

public class s10570 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int answer = 0;
            for (int i = A; i <= B; i++){
                double ii = Math.sqrt(i);

                if (ii % (int)ii == 0 && check(i) && check((int)ii)) answer++;
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean check(int n){
        char[] arr = String.valueOf(n).toCharArray();
        for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--){
            if (arr[i] != arr[j]) return false;
        }
        return true;
    }
}