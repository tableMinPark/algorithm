import java.util.LinkedList;
import java.util.Queue;

public class p3_1 {
    static boolean[] v;
    public static int solution(int n, int[][] computers){
        int answer = 0;
        v = new boolean[n];

        for (int i = 0; i < n; i++){
            if (!v[i]) {
                BFS(i, n, computers);
                answer++;
            }
        }

        return answer;
    }

    public static void BFS(int s, int n, int[][] computers){
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++){
            if (computers[s][i] == 1 && i != s) q.add(i);
        }
        v[s] = true;

        while (!q.isEmpty()){
            int p = q.poll();
            v[p] = true;

            for (int i = 0; i < n; i++){
                if (computers[p][i] == 1 && i != p && !v[i]) q.add(i);
            }
        }
    }

    public static void main(String[] args) {
        int[][] t1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] t2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        System.out.println(solution(3, t1));
        System.out.println(solution(3, t2));
    }
}

/**
모범답안

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] chk = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!chk[i]) {
                dfs(computers, chk, i);
                answer++;
            }
        }
        return answer;
    }
    void dfs(int[][] computers, boolean[] chk, int start) {
        chk[start] = true;
        for(int i = 0; i < computers.length; i++) {
            if(computers[start][i] == 1 && !chk[i]) {
                dfs(computers, chk, i);
            }
        }
    }
}

 */
