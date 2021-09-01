import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cn = Integer.parseInt(st.nextToken());

            float avg = 0;
            int[] n = new int[cn];
            int s = 0;
                        
            for (int j = 0; j < cn; j++) {
                n[j] = Integer.parseInt(st.nextToken());
                avg += n[j];
            }
            avg /= cn;
            for (int j = 0; j < cn; j++) if (n[j] > avg) s++;
            sb.append(String.format("%.3f", (float) s / cn * 100)).append("%\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    
}
