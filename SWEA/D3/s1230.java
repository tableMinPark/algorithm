import java.io.*;
import java.util.*;

public class s1230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++){
            int N = Integer.parseInt(br.readLine());
            List<Integer> arr = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr.add(Integer.parseInt(st.nextToken()));

            int C = Integer.parseInt(br.readLine());
            StringTokenizer ct = new StringTokenizer(br.readLine());

            for (int i = 0; i < C; i++){
                char c = ct.nextToken().charAt(0);

                if (c == 'I'){
                    int x = Integer.parseInt(ct.nextToken());
                    int y = Integer.parseInt(ct.nextToken());
                    for (int j = x + 1; j < x + 1 + y; j++) arr.add(j, Integer.parseInt(ct.nextToken()));
                } else if (c == 'D'){
                    int x = Integer.parseInt(ct.nextToken());
                    int y = Integer.parseInt(ct.nextToken());
                    for (int j = 0; j < y; j++) arr.remove(x + 1);

                } else{
                    int y = Integer.parseInt(ct.nextToken());
                    for (int j = 0; j < y; j++) arr.add(Integer.parseInt(ct.nextToken()));
                }
            }

            sb.append("#").append(t).append(" ");
            for (int i = 0; i < 10; i++) sb.append(arr.get(i)).append(" ");
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}