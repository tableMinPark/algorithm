import java.io.*;

public class s3131 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int MAX = 1000000;

        boolean[] arr = new boolean[MAX + 1];

        for (int i = 2; i <= MAX; i++){
            for (int j = i + i; j <= MAX; j += i){
                if (arr[j]) continue;
                arr[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= MAX; i++){
            if (!arr[i]) sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}