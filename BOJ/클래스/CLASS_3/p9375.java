import java.io.*;
import java.util.*;

public class p9375 {

    static int T, N, answer;
    static Map<String, Integer> cloth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){

            cloth = new HashMap<>();

            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++){
                st  = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();
                if (cloth.containsKey(kind)) cloth.put(kind, cloth.get(kind) + 1);
                else cloth.put(kind, 1);
            }

            answer = 1;
            for (String key : cloth.keySet()) answer *= cloth.get(key) + 1;
            answer--;

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString().trim());
        br.close();
    }
}