import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken()); st.nextToken();            
            int N = Integer.parseInt(st.nextToken());
            int f = N % H;
            int n = N / H;
            if (f == 0){
                sb.append((H * 100) + n).append("\n");
            } else{
                sb.append((f * 100) + n + 1).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    
}
