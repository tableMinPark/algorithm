import java.io.*;
import java.util.*;

public class p2116 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][6];
        StringTokenizer st;

        int[] idx = {0, 1, 2, 4, 5, 3};

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) arr[i][idx[j]] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;

        for (int i = 0; i < 6; i++){
            int bottom = arr[0][i];
            int top = arr[0][(i + 3) % 6];
            int sum = sideMax(bottom, top);

            for (int j = 1; j < N; j++){
                for (int k = 0; k < 6; k++){
                    if (arr[j][k] == top){
                        bottom = arr[j][k];
                        top = arr[j][(k + 3) % 6];
                        break;
                    }
                }
                sum += sideMax(bottom, top);
            }
            answer = Math.max(answer, sum);
        }
        
        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }

    public static int sideMax(int bottom, int top){
        if (bottom + top == 11) return 4;
        else if (bottom == 6 || top == 6) return 5;
        else return 6;
    } 
}