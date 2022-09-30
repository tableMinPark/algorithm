import java.io.*;
import java.util.*;

public class p1620{

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for (int i = 1; i <= N; i++){
            String input = br.readLine();
            map.put(input, Integer.toString(i));
            map.put(Integer.toString(i), input);
        }

        for (int i = 0; i < M; i++){
            sb.append(map.get(br.readLine())).append("\n");    
        }

        System.out.println(sb.toString().trim());
        br.close();
    }
}