import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        if (A > B){
            int t = A;
            A = B;
            B = t;
        }
        int r1 = 0;
        for (int i = 1; i <= B; i++){
            if (A % i == 0 && B % i == 0) r1 = i;
        }
        sb.append(r1).append("\n");
        
        int r2 = 0;
        while (true){
            r2 += B;
            if (r2 % A == 0){
                sb.append(r2);
                break;
            }
        }
        bw.write(sb.toString());


        bw.flush();
        br.close();
        bw.close();
    }
}
