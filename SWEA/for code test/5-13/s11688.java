import java.io.*;

public class s11688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            char[] arr = br.readLine().toCharArray();
            
            int a = 1;
            int b = 1;

            for (char ar : arr){
                if (ar == 'L'){
                    b = a + b;
                } else {
                    a = a + b;
                }
            }

            sb.append("#").append(t).append(" ").append(a).append(" ").append(b).append("\n");            
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}