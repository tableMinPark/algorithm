import java.io.*;
import java.util.*;

public class p1764 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Set<String> arr = new HashSet<>();
        String[] input = new String[M];

        int count = 0;
        
        for (int i = 0; i < N; i++) arr.add(br.readLine());
        for (int i = 0; i < M; i++) input[i] = br.readLine();

        Arrays.sort(input);

        for (String i : input){
            if (arr.contains(i)) {
                sb.append(i).append("\n");
                count++;
            }
        }
        System.out.println(count);
        System.out.println(sb.toString().trim());
        br.close();
    }
}