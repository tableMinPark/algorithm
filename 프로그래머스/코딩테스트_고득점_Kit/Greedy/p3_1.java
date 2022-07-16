import java.util.*;

public class p3_1{
    static int[] parent;
    public static int solution(int n, int[][] costs){
        int answer = 0;

        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        Arrays.sort(costs, (n1, n2) -> {
            return n1[2] - n2[2];
        });

        for (int i = 0; i < costs.length; i++){
            int s = find(costs[i][0]);
            int e = find(costs[i][1]);

            if (s == e) continue;
            
            parent[e] = s;            
            answer += costs[i][2];
        }

        return answer;
    }

    public static int find(int x){
        if (parent[x] == x) return x;
        else return parent[parent[x]] = find(parent[x]);
    }

    public static void main(String[] args) {
        int[][] t1 = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3 ,8}};        
        int[][] t2 = {{2, 3, 3}, {1, 6, 5}, {2, 4, 6}, {1, 2, 7}, {4, 5 ,7}};

        System.out.println(solution(4, t1));
        System.out.println(solution(7, t2));
    }
}