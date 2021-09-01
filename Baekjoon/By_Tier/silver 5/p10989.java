import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p10989 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());

        //Arrays.sort 사용
        /*
        int[] n = new int[c];
        for (int i = 0; i < c; i++) n[i] = Integer.parseInt(br.readLine());
        Arrays.sort(n);
        StringBuilder sb = new StringBuilder();        
        for (int i = 0; i < c; i++) sb.append(n[i]).append("\n");
        */

        //정수형배열 카운트 -> sort보다 빠름
        /**/        
        int[] n = new int[10000];
        for (int i = 0; i < c; i++) n[Integer.parseInt(br.readLine()) - 1]++;        
        StringBuilder sb = new StringBuilder();   
        for (int i = 0; i < 10000; i++) for (int j = 0; j < n[i]; j++) sb.append(i + 1).append("\n");
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
