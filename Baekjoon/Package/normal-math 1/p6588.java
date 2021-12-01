import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p6588{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        boolean[] n = new boolean[1000001];

        for (int i = 2; i < n.length; i++){
            if (n[i]) continue;
            for (int j = i + i; j < n.length; j += i){
                n[j] = true;
            }
        }

        int input;
        loop : while((input = Integer.parseInt(br.readLine())) != 0){
            for (int i = 3; i <= input / 2; i++){
                if (!n[i]){
                    if(!n[input - i]) {
                        sb.append(input).append(" = ").append(i).append(" + ").append(input - i).append("\n");
                        //sb.append(String.format("%d = %d + %d", input, i, input - i)).append("\n");
                        //String.format을 사용해 형식지정자로 정수를 지정하면 시간이 4배이상 걸린다.
                        //append로만 사용시 392ms / format 사용시 1200ms 이상 
                        continue loop;
                    }
                }
            }
            sb.append("Goldbach's conjecture is wrong.").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}