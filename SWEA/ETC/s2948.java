import java.io.*;
import java.util.*;

public class s2948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[][] arr = {br.readLine().split(" "), br.readLine().split(" ")};

            Set<String> set = new HashSet<>();

            int min, max;
            if (N > M) max = 0;
            else max = 1;
            min = max == 0 ? 1 : 0;

            for (int i = 0; i < arr[max].length; i++) set.add(arr[max][i]);

            int answer = 0;
            for (String a : arr[min]){
                if (set.contains(a)) answer++;
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}