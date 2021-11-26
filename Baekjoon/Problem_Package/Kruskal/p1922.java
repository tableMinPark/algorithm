import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1922{
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int answer = 0;

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        int[][] costs = new int[M][3];

        for (int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());            
            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(costs, (n1, n2) -> {
            return n1[2] - n2[2];
        });

        for (int i = 0; i < costs.length; i++){
            int sParent = find(costs[i][0]);
            int eParent = find(costs[i][1]);

            //사이클방지
            if (sParent == eParent) continue;

            parent[eParent] = sParent;
            answer += costs[i][2];
        }
        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }

    public static int find(int x){
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}