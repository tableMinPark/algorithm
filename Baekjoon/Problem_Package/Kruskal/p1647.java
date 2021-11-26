import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1647 {
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        int[][] costs = new int[M][3];

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());

            if (costs[i][0] > costs[i][1]){
                int temp = costs[i][1];
                costs[i][1] = costs[i][0];
                costs[i][0] = temp;
            }
        }

        Arrays.sort(costs, (n1, n2) -> {
            return n1[2] - n2[2];
        });

        int answer = 0;
        int max = 0;

        for (int i = 0; i < M; i++){
            int sParent = find(costs[i][0]);
            int eParent = find(costs[i][1]);

            if (sParent == eParent) continue;
            
            parent[eParent] = sParent;
            answer += costs[i][2];
            max = costs[i][2];
        }
        
        bw.write(String.valueOf(answer - max));
        br.close();
        bw.flush();
        bw.close();
    }
    public static int find(int x){
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}
