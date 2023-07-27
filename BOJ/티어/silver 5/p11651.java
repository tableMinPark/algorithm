import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        int[][] p = new int[c][2];

        for (int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(p, new Comparator<int[]>(){
            @Override
            public int compare(int[] p1, int[] p2){
                if (p1[1] == p2[1]){
                    return p1[0] - p2[0];
                }
                else{
                    return p1[1] - p2[1];
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c; i++) sb.append(p[i][0]).append(" ").append(p[i][1]).append("\n");

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
