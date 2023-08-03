import java.io.*;
import java.util.StringTokenizer;

public class BJ_1976 {
    static int N, M;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        for (int a = 1; a <= N; a++) {
            st = new StringTokenizer(br.readLine());
            for (int b = 1; b <= N; b++) {
                int n = Integer.parseInt(st.nextToken());

                if (n == 1) {
                    union(a, b);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int now = Integer.parseInt(st.nextToken());

        String answer = "YES";
        for (int i = 1; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());

            if (find(now) != find(next)) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);
        br.close();
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return;
        }

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static int find(int n) {
        if (parent[n] == n) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }
}
