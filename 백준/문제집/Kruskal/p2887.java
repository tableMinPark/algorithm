import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p2887 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] planet = new int[N][4];
        PriorityQueue<Integer[]> costs = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] n1, Integer[] n2){
                return n1[2] - n2[2];
            }
        });
        
        parent = new int[N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) planet[i][j] = Integer.parseInt(st.nextToken());
            planet[i][3] = i;
            parent[i] = i;
        }

        Arrays.sort(planet, (n1, n2) -> {
            return n1[0] - n2[0];
        });
        for (int i = 1; i < N; i++){
            Integer[] temp = {planet[i - 1][3], planet[i][3], Math.abs(planet[i - 1][0] - planet[i][0])};
            costs.add(temp);
        }
        
        //Y축 정렬
        Arrays.sort(planet, (n1, n2) -> {
            return n1[1] - n2[1];
        });
        for (int i = 1; i < N; i++){
            Integer[] temp = {planet[i - 1][3], planet[i][3], Math.abs(planet[i - 1][1] - planet[i][1])};
            costs.add(temp);
        }
        
        //Z축 정렬
        Arrays.sort(planet, (n1, n2) -> {
            return n1[2] - n2[2];
        });
        for (int i = 1; i < N; i++){
            Integer[] temp = {planet[i - 1][3], planet[i][3], Math.abs(planet[i - 1][2] - planet[i][2])};
            costs.add(temp);
        }
        
        int answer = 0;

        while(!costs.isEmpty()){
            Integer[] cost = costs.poll();

            int sParent = find(cost[0]);
            int eParent = find(cost[1]);

            if (sParent == eParent) continue;

            parent[eParent] = sParent;
            answer += cost[2];
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

//참고한 블로그
//https://dev-jk.tistory.com/29