import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p17404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][3];
        int[][] color = new int[N + 1][3];
        
        for (int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            color[i][0] = Integer.parseInt(st.nextToken());
            color[i][1] = Integer.parseInt(st.nextToken());            
            color[i][2] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++){
            for (int k = 0; k < 3; k++){
                if (k == j) dp[1][k] = color[1][k];
                else dp[1][k] = 1000 * 1000 + 1;
            }
            for (int i = 2; i <= N; i++){
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + color[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + color[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + color[i][2];
            }
            for (int i = 0; i < 3; i++){
                if (i != j) result = Math.min(result, dp[N][i]);
            }
        }
        bw.write(Integer.toString(result));
        bw.flush();
        br.close();
        bw.close();
    }
}

/**
 * 처음에 시작점을 R로 고정하고 나오는 결과중에서 가장 최솟값은 시작점 R을 제외하고 G와 B의 최솟값을 구한다. 
 * (시작점과 끝점의 색을 달라야 하기 때문)
 * G와 B를 위와같이 고정하고 나오는 최솟값 총 3개를 비교하여 가장 작은 값을 결과 값을 출력한다.
 */