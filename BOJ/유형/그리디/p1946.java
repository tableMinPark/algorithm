import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p1946 {

    static class Score{
        int test;
        int inter;
        public Score(int test, int inter){
            this.test = test;
            this.inter = inter;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            Score[] arr = new Score[N];

            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int test = Integer.parseInt(st.nextToken());
                int inter = Integer.parseInt(st.nextToken());
                arr[i] = new Score(test, inter);
            }

            Arrays.sort(arr, new Comparator<Score>() {
                @Override
                public int compare(Score s1, Score s2) {
                    if (s1.test == s2.test) return s2.inter - s1.inter;
                    return s1.test - s2.test;
                }
                
            });

            int answer = 1;
            int min = arr[0].inter;
            for (int i = 1; i < N; i++){
                if (arr[i].inter < min){
                    answer++;
                    min = arr[i].inter;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString().trim());
        br.close();
    }
}
