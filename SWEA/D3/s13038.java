import java.io.*;
import java.util.*;

public class s13038 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

		for(int t = 1; t <= T; t++)
		{
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            int[] arr = new int[8];
            for (int i = 1; i <= 7; i++) {
                arr[i] = Integer.parseInt(st.nextToken());     
            }
            
            int answer = Integer.MAX_VALUE;

            for (int i = 1; i <= 7; i++){
                if (arr[i] == 0) continue;
                int idx = i;
                int n = N;
                int cnt = 0;

                while(n > 0){
                    if (arr[idx] == 1) n--;
                    cnt++;
                    if (idx == 7) idx = 1;
                    else idx++;
                }
                answer = Math.min(answer, cnt);
            }
            

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}