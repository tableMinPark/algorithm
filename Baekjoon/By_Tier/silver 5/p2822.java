import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class p2822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer[][] s = new Integer[8][2];

        for (int i = 0; i < 8; i++){
            s[i][0] = Integer.parseInt(br.readLine());
            s[i][1] = i + 1;
        }
        
        Arrays.sort(s, new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] s1, Integer[] s2){
                return s2[0] - s1[0];
            }
        });
        int sum = 0;
        int[] m = new int[5];

        for (int i = 0; i < 5; i++){
            sum += s[i][0];
            m[i] = s[i][1];
        }
        Arrays.sort(m);

        StringBuilder sb = new StringBuilder();
        sb.append(sum).append("\n");

        for (int i = 0; i < 5; i++){
            sb.append(m[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
