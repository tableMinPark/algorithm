import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c; i++){
            String s = br.readLine();

            int count = 0;
            int sum = 0;

            for (int j = 0; j < s.length(); j++){
                if (s.charAt(j) == "O".charAt(0)){
                    sum += ++count;                    
                }
                else{
                    count = 0;
                }
            }
            sb.append(sum).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
