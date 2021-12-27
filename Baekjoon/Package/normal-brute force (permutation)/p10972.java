import java.io.*;
import java.util.*;

public class p10972 {
    static int N;
    static int[] input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        input = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) input[i] = Integer.parseInt(st.nextToken());

        if (!nextPermutation()) sb.append(-1);        

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean nextPermutation(){
        int idx = input.length - 1;
        while (idx > 0 && input[idx - 1] >= input[idx]) { idx--; }
        if (idx <= 0) return false;

        idx--;
        int nextIdx = input.length - 1;
        while (input[nextIdx] <= input[idx]) { nextIdx--; }
        
        int temp = input[idx];
        input[idx] = input[nextIdx];
        input[nextIdx] = temp;
        
        for (int i = 0; i <= idx; i++) sb.append(input[i]).append(" ");        
        for (int i = N - 1; i > idx ; i--) sb.append(input[i]).append(" ");

        return true;
    }
}

// 규칙을 찾아서 간단한 코드로 적용할 수 있다. (시간초과, 메모리초과)