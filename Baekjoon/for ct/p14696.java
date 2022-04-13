import java.io.*;
import java.util.*;

public class p14696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int i = 0; i < N; i++){
            int[][] arr = new int[2][5];

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) arr[0][Integer.parseInt(st.nextToken())]++;

            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            for (int j = 0; j < b; j++) arr[1][Integer.parseInt(st.nextToken())]++;

            char answer = ' ';

            for (int j = 4; j > 0; j--){
                if (arr[0][j] == arr[1][j]) continue;
                else{
                    answer = arr[0][j] > arr[1][j] ? 'A' : 'B';
                    break;
                }
            }
            if (answer == ' ') answer = 'D';

            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}