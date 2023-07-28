import java.util.*;

class Solution {

    static final int MOD = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] dist = new int[n + 1][m + 1];
        dist[1][1] = 1;

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (y == 1 && x == 1) continue;
                if (isPuddle(y, x, puddles)) continue;
                dist[y][x] = (dist[y - 1][x] + dist[y][x - 1]) % MOD;
            }
        }

        return dist[n][m];
    }
    static boolean isPuddle(int y, int x, int[][] puddles) {
        for (int[] puddle : puddles) {
            if (puddle[0] == x && puddle[1] == y) {
                return true;
            }
        }
        return false;
    }
}