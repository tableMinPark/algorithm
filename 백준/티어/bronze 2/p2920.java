import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] n = new int[9];
        for (int i = 0; i < 8; i++) n[i] = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        if (n[0] != 1 && n[0] != 8){
            sb.append("mixed");
        } else{
            for (int i = 1; i < 8; i++) {
                if (Math.abs(n[i] - n[i - 1]) != 1){
                    sb.append("mixed");
                    break;
                }
                if (i == 7 && n[0] == 1) sb.append("ascending");
                if (i == 7 && n[0] == 8) sb.append("descending");
            }            
        }
        
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
