// DP

class PG_정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;

        int N = triangle.length;

        int[][] dist = new int[N][N];
        dist[0][0] = triangle[0][0];

        int M = 1;
        for (int y = 0; y < N - 1; y++, M++) {
            for (int x = 0; x < M; x++) {
                int left = triangle[y + 1][x] + dist[y][x];
                int right = triangle[y + 1][x + 1] + dist[y][x];
                dist[y + 1][x] = Math.max(dist[y + 1][x], left);
                dist[y + 1][x + 1] = Math.max(dist[y + 1][x + 1], right);
                answer = Math.max(answer, dist[y + 1][x]);
                answer = Math.max(answer, dist[y + 1][x + 1]);
            }
        }
        return answer;
    }
}