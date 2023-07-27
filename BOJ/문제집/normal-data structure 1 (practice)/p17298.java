import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class p17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        Stack<Integer> s = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++){
            while (!s.isEmpty() && A[s.peek()] < A[i]){
                A[s.pop()] = A[i];
            }
            s.push(i);            
        }
        while (!s.isEmpty()) A[s.pop()] = -1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(A[i]).append(" ");
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
//https://st-lab.tistory.com/196