import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int c = Integer.parseInt(br.readLine());
        for (int i = 1; i <= c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append("Case #" + i + ": ");
            sb.append((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())));
            sb.append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
    
}
/*
sb.append(<Integer>) -> 가능하다 (Integer.toString() 사용할 필요없음)
속도 -> sb.toString() > String.valueOf(sb)
*/