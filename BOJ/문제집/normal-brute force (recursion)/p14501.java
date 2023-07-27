import java.io.*;
import java.util.*;

public class p14501 {
    static int N;
    static int[][] arr;
    static boolean[] v;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1][2];
        v = new boolean[N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        DFS(1);

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int idx){
        for (int i = idx; i <= N; i++){
            if (i + arr[i][0] > N + 1) continue;
            v[i] = true;
            DFS(i + arr[i][0]);
            v[i] = false;
        }
        int sum = 0;
        for (int i = 1; i <= N; i++){
            if (v[i]) sum += arr[i][1];
        }
        answer = Math.max(answer, sum);
        return;
    }
}