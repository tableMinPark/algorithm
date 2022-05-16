import java.io.*;
import java.util.*;

public class s6190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

            int answer = -1;

            for (int i = 0; i < N - 1; i++){
                for (int j = i + 1; j < N; j++){
                    int mul = arr[i] * arr[j];
                    char[] str = String.valueOf(mul).toCharArray();

                    boolean check = true;
                    for (int k = 1; k < str.length; k++){
                        if (str[k - 1]-'0' > str[k]-'0'){
                            check = false;
                            break;
                        }
                    }
                    if (check && str.length > 1) answer = Math.max(answer, mul);
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}