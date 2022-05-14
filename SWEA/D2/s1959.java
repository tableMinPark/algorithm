import java.io.*;
import java.util.*;

public class s1959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());            
            
            StringTokenizer stn = new StringTokenizer(br.readLine());
            StringTokenizer stm = new StringTokenizer(br.readLine());
            int[] arr;
            Queue<Integer> q = new LinkedList<>();

            if (N > M){
                arr = new int[N];
                for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(stn.nextToken());
                for (int i = 0; i < M; i++) q.add(Integer.parseInt(stm.nextToken()));
            } else {
                arr = new int[M];
                for (int i = 0; i < M; i++) arr[i] = Integer.parseInt(stm.nextToken());
                for (int i = 0; i < N; i++) q.add(Integer.parseInt(stn.nextToken()));
            }

            int answer = 0;
            for (int i = 0; i <= arr.length - q.size(); i++){
                int sum = 0;
                for (int j = i; j < i + q.size(); j++){
                    int n = q.poll();
                    sum += arr[j] * n;
                    q.add(n);
                }
                answer = Math.max(answer, sum);
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}