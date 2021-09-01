import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1010 {
    static int dp[][] = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            //sb.append(fac(M) / (fac(N) * fac(M - N))).append("\n");   
            sb.append(C(M, N)).append("\n"); 
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    public static int C(int M, int N){
        //이미 연산된 결과값은 바로 꺼내간다. (DP 알고리즘)
        if (dp[M][N] > 0) return dp[M][N];
        if (N == M || N == 0) return dp[M][N] = 1;
        return dp[M][N] = C(M - 1, N - 1) + C(M - 1, N);
    }

    /*
    //팩토리얼로 풀면 13 29 -> 케이스가 정수크기 초과로 결과가 0이 나온다.
    public static int fac(int n){
        if (n <= 1) return 1;
        else return n * fac(n - 1);
    }
    */
}

/*
nCm = n! / { m! * (n - m)! }
m개의 도착점에서 n개의 출발점을 뽑는다. (조합)
조합의 경우는 다리가 겹치는 것과는 상관없이 둘 다 하나의 경우로 보기 때문에
다리가 겹치는 경우는 제외될 수 밖에 없다.
*/