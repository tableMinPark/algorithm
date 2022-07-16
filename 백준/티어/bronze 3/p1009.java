import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()); 
            int r = 1;
            for (int j = 0; j < b; j++) r = (r * a) % 10;
            if (r == 0) r = 10;
            sb.append(r).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
/*
터무니 없이 큰 숫자를 표현할 수 없기 때문에 곱하고 %10 한 나머지를 
다시 곱하는 것을 반복하여 
계산이 끝난 수의 일의자리만 알아낼 수 있다.

나머지가 0이 나오면 10으로 출력될 수 있게 if로 값을 변경한다.
*/
