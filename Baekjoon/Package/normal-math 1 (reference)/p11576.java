import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class p11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Stack<Integer> r = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int ten = 0;

        for (int i = m - 1; i >= 0; i--){
            int N = Integer.parseInt(st.nextToken());
            ten += N * Math.pow(A, i);
        }
        
        while (ten != 0){
            r.push(ten % B);
            ten /= B;
        }
        while (!r.isEmpty()) sb.append(r.pop()).append(" ");
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}