import java.io.*;

public class p8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < testCase; t++){
            char[] arr = br.readLine().toCharArray();

            int sum = 0;
            int result = 0;

            for (int i = 0; i < arr.length; i++){
                if (arr[i] == 'X') sum = 0;
                if (arr[i] == 'O') sum++;                
                result += sum;
            }
            sb.append(result).append("\n");

        }
        
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}