import java.io.*;
import java.util.*;

public class p10973 {
    static int N;
    static Integer[] input;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        input = new Integer[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) input[i] = Integer.parseInt(st.nextToken());

        sort();

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    public static void sort(){        
        int temp = Integer.MAX_VALUE;
        for (int i = N - 1; i >= 0; i--){
            if (temp > input[i]){
                temp = input[i];
                continue;
            }

            Arrays.sort(input, i + 1, N, Collections.reverseOrder());
            
            //내림차순 된 부분에서 i번째 수보다 크지 않은 가장 큰 수를 찾아야함
            int maxIdx;
            for (maxIdx = i + 1; maxIdx < N; maxIdx++){
                if (input[maxIdx] < input[i]) break;
            }
            temp = input[i];
            input[i] = input[maxIdx];
            input[maxIdx] = temp;
            
            for (int  in : input) sb.append(in).append(" ");
            return;
        }
        sb.append(-1);        
    }
}