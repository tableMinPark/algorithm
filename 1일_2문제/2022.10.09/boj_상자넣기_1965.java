import java.io.*;
import java.util.*;

public class boj_상자넣기_1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] box = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) box[i] = Integer.parseInt(st.nextToken());

        int[] memoi = new int[N];
        int len = 0;
        for (int i = 0; i < N; i++){
            int pos = Arrays.binarySearch(memoi, 0, len, box[i]);
            
            // 이미 같은 숫자가 있는 경우
            if (pos >= 0) continue;

            // 동일한 숫자가 없는 경우
            pos = Math.abs(pos) - 1;
            memoi[pos] = box[i];
            
            // 현재 시점에서 가장 큰 수가 들어와서 가장 뒤에 값이 추가되는 경우 
            // 길이 + 1
            if (len == pos) len++;
        }
        
        System.out.println(len);
        br.close();
    }
}