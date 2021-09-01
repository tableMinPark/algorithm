import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2480 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] n = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++){
            n[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(n);
        if (n[0] == n[1] && n[1] == n[2]){
            bw.write(Integer.toString(10000 + n[1] * 1000));
        } else if (n[0] == n[1] || n[1] == n[2]){
            bw.write(Integer.toString(1000 + n[1] * 100));
        } else{
            bw.write(Integer.toString(n[2] * 100));
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
