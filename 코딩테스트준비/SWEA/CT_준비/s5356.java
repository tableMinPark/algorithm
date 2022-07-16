import java.io.*;
import java.util.*;

public class s5356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            sb.append("#").append(t).append(" ");

            int len = 0;

            Queue<Character>[] q = new LinkedList[5];
            for (int i = 0; i < 5; i++){
                q[i] = new LinkedList<>();
                char[] input = br.readLine().toCharArray();
                for (int j = 0; j < input.length; j++){
                    q[i].add(input[j]);
                    len++;
                }
            }

            int cnt = 0;

            while(cnt != len){
                for (int i = 0; i < 5; i++){
                    if (q[i].isEmpty()) continue;
                    sb.append(q[i].poll());
                    cnt++;
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}