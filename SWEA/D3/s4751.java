import java.io.*;

public class s4751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        String[] str = {".#..", "#.#.", ".", "#.#.", ".#.."};

        for (int t = 1; t <= T; t++){
            char[] arr = br.readLine().toCharArray();

            for (int i = 0; i < 5; i++){ 
                if (i == 2) sb.append("#");
                else sb.append(".");    
                
                for (int j = 0; j < arr.length; j++){
                    if (i == 2){
                        sb.append(str[i]).append(arr[j]).append(".#");
                    } else{
                        sb.append(str[i]);
                    }
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}