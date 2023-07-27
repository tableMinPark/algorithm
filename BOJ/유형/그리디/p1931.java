import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1931{

    static class Meet implements Comparable<Meet>{
        int s;
        int e;
        public Meet(int s, int e){
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(Meet m){
            if (this.e == m.e) return this.s - m.s;
            return this.e - m.e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Meet[] arr = new Meet[N];
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i] = new Meet(s, e);
        }

        Arrays.sort(arr);

        int answer = 0;
        int pre = 0;
        for(Meet a : arr){
            if (a.s >= pre) {
                answer++;
                pre = a.e;
            }
        }

        System.out.println(answer);
        br.close();
    }
}