import java.io.*;
import java.util.*;

public class s1240 {
    static int[] ns = {1101, 11001, 10011, 111101, 100011, 110001, 101111, 111011, 110111, 1011};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][M];
            int[] cnt = new int[N];

            for (int y = 0; y < N; y++){
                String[] input = br.readLine().split("");
                for (int x = 0; x < M; x++){
                    arr[y][x] = Integer.parseInt(input[x]);
                    if (arr[y][x] == 1) cnt[y]++;
                }
            }

            int answer = 0;

            for (int y = 0; y < N; y++){
                if (cnt[y] == 0) continue;
                int idx = -1;
                for (int x = M - 1; x >= 0; x--){
                    if (arr[y][x] == 1){
                        idx = x;
                        break;
                    }
                }

                List<Integer> ans = new ArrayList<>();

                for (int x = idx - 55; x <= idx; x += 7){
                    String temp = "";
                    for (int i = x; i < x + 7; i++){
                        temp += arr[y][i];
                    }
                    ans.add(find(Integer.parseInt(temp)));
                }

                int es = 0, os = 0;
                int sum = 0;
                for (int i = 0; i < ans.size(); i++){
                    if ((i + 1) % 2 == 0) es += ans.get(i);
                    else os += ans.get(i);
                    sum += ans.get(i);
                }

                int code = os * 3 + es;

                answer = code % 10 == 0 ? sum : 0;
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");            
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static int find(int num){
        for (int i = 0; i < ns.length; i++){
            if (num == ns[i]) return i;
        } return -1;
    }
}