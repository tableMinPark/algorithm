import java.io.*;
import java.util.*;

public class BJ_4195 {
    static int T, F;
    static Map<String, String> parent;
    static Map<String, Integer> count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            F = Integer.parseInt(br.readLine());

            parent = new HashMap<>();
            count = new HashMap<>();

            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());

                String a = st.nextToken();
                String b = st.nextToken();

                if (!parent.containsKey(a)) {
                    parent.put(a, a);
                    count.put(a, 1);
                }
                if (!parent.containsKey(b)) {
                    parent.put(b, b);
                    count.put(b, 1);
                }

                union(a, b);

                int answer = count.get(find(a));
                sb.append(answer).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    static void union(String a, String b) {
        a = find(a);
        b = find(b);

        if (a.equals(b)) {
            return;
        }

        int totalCount = count.get(a) + count.get(b);
        parent.put(a, b);
        count.put(b, totalCount);
    }

    static String find(String n) {
        if (parent.get(n).equals(n)) {
            return n;
        }

        String p = find(parent.get(n));
        parent.put(n, p);
        return p;
    }
}
