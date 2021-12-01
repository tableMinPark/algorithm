import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p10814 {
    static String[][] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());

        p = new String[c][3];

        for (int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            p[i][0] = st.nextToken();
            p[i][1] = st.nextToken();
            p[i][2] = Integer.toString(i);
        }

        Arrays.sort(p, new Comparator<String[]>(){
            @Override
            public int compare(String[] s1, String[] s2){
                if (Integer.parseInt(s1[0]) == Integer.parseInt(s2[0])){
                    return Integer.parseInt(s1[2]) - Integer.parseInt(s2[2]);
                }
                else{                    
                    return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
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
