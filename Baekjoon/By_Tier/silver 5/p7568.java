import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());

        int[][] p = new int[c][2];

        for (int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
            
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c; i++){
            int count = 1;
            for (int j = 0; j < c; j++){
                if (p[i][0] < p[j][0] && p[i][1] < p[j][1]) count++;
            }
            sb.append(count).append(" ");
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
