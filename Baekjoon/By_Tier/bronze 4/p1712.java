import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        if (B < C){
            bw.write(Integer.toString(A / (C - B) + 1));
        } else{
            bw.write("-1");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

/*

C * r > A + B * r
= (C - B) * r > A
= r > A / (C - B)
이렇게 나오기 떄문에
A / (C - B) 에  +1 을 해주면 손익분기점을 구할 수 있음

*/
