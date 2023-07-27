import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> s = new ArrayList<>();
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == 0 && B == 0) break;
            else s.add(A + B);                        
        }
        for (int i = 0; i < s.size(); i++) bw.write(Integer.toString(s.get(i)) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }    
}
/*
ArrayList를 사용해도되지만 
StringBuilder를 사용하면 따로 출력문을 위해 for문을 사용하지 않아도된다.
StringBuilder sb = new StringBuilder();
sb.append((1 + 1)).append("\n");
bw.write(sb)
*/
