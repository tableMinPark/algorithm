import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] n = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());            
            for (int j = 0; j < M; j++) n[i][j] = Integer.parseInt(st.nextToken());
        }

        int c = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c; i++){
            st = new StringTokenizer(br.readLine());

            int I = Integer.parseInt(st.nextToken()) - 1;
            int J = Integer.parseInt(st.nextToken()) - 1;
            int X = Integer.parseInt(st.nextToken()) - 1;
            int Y = Integer.parseInt(st.nextToken()) - 1;
            
            int sum = 0;

            for (int j = J; j <= Y; j++){
                for (int k = I; k <= X; k++) sum += n[k][j];
            }

            sb.append(sum).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
