import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1697 {
    static int N;
    static int K;
    static int[] v;
    static int[] m = {-1, 1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        v = new int[1000001];
        BFS();
        bw.write(Integer.toString(v[K] - 1));

        bw.flush();
        br.close();
        bw.close();
    }
    public static void BFS(){
        Queue<subin> q = new LinkedList<>();
        q.add(new subin(N, 1));
        v[N] = 1;

        while (!q.isEmpty()){
            subin s = q.poll();

            if (s.l == K){
                break;
            }
            for (int i = 0; i < 3; i++){
                int temp = i == 2 ? s.l * m[i] : s.l + m[i];
                if (temp > 1000000 || temp < 0) continue;
                if (v[temp] != 0) continue;
                q.add(new subin(temp, s.c + 1));
                v[temp] = s.c + 1;
            }
        }        
    }
}
class subin{
    int l;
    int c;

    subin(int l, int c){
        this.l = l;
        this.c = c;
    }
}