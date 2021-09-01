import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class p17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] v = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            v[A[i]]++;
        }        

        Stack<Integer> s = new Stack<>();
        s.push(0);

        for (int i = 1; i < N; i++){
            if (v[A[s.peek()]] < v[A[i]]){
                while (!s.isEmpty()){
                    if (v[A[s.peek()]] < v[A[i]]) A[s.pop()] = A[i];
                    else break;
                }
            }
            s.push(i);            
        }
        while(!s.isEmpty()) A[s.pop()] = -1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(A[i] + " ");
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}