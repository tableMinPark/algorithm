import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());

        boolean[][] p = new boolean[100][100];

        int a = 0;

        for (int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++){
                for (int k = y; k < y + 10; k++){
                    if (!p[j][k]){
                        a++;
                        p[j][k] = true;
                    }
                }
            }
        }
        bw.write(Integer.toString(a));       

        bw.flush();
        br.close();
        bw.close();
    }
}
