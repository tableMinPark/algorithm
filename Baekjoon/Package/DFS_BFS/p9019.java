import java.io.*;
import java.util.*;

public class p9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++){
            Queue<Integer> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            String[] answer = new String[10000];
            boolean[] v = new boolean[10000];
            
            q.add(A);
            v[A] = true;
            Arrays.fill(answer, "");

            BFS(q, B, v, answer);

            sb.append(answer[B]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();        
    }
    public static void BFS(Queue<Integer> q, int B,boolean[] v, String[] answer){
        while(!q.isEmpty()){
            int now = q.poll();

            int D = D(now);
            int S = S(now);
            int L = L(now);
            int R = R(now);
            
            if (!v[D]){
                q.add(D);
                answer[D] = answer[now] + "D";
                v[D] = true;
            }
            if (!v[S]){
                q.add(S);
                answer[S] = answer[now] + "S";
                v[S] = true;
            }
            
            if (!v[L]){
                q.add(L);
                answer[L] = answer[now] + "L";
                v[L] = true;
            }
                
            if (!v[R]){
                q.add(R); 
                answer[R] = answer[now] + "R";
                v[R] = true;
            }
        }
    }
    public static int D(int n){
        return  n * 2 > 9999 ? (n * 2) % 10000 : n * 2;
    }
    public static int S(int n){
        return n == 0 ? 9999 : n - 1;
    }
    public static int L(int n){
        return (n % 1000) * 10 + n / 1000;
    }
    public static int R(int n){
        return (n % 10) * 1000 + n / 10;
    }
}

// 참고한 블로그 > https://log-laboratory.tistory.com/134
// 노드클래스 생성 후, 노드에 커멘드 저장하는 방식 > https://www.acmicpc.net/source/36408013
// 위의 방법은 처음 생각했었던 방식이었지만 메모리 초과가 날 것 같아서 시도하지 않았음
// String[] 를 생성해 저장하는 것보다는 위의 방식이 더 빠름