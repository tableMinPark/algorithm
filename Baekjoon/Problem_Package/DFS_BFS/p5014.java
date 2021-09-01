import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p5014 {
    static int F;   //전체층
    static int S;   //회사층
    static int G;   //현재층
    static int U;   //위
    static int D;   //아래
    static boolean[] v;
    static int[] ud;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        v = new boolean[F + 1];
        ud = new int[2];
        int count = BFS();
        if (count == -1) sb.append("use the stairs");
        else sb.append(count);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    public static int BFS(){
        Queue<elev> q = new LinkedList<>();
        q.add(new elev(S, 0));
        v[S] = true;

        while (!q.isEmpty()){
            elev t = q.poll();

            if (t.n == G) return t.c;
            ud[0] = U;
            ud[1] = D * (-1);
            
            for (int i = 0; i < 2; i++){
                int temp = t.n + ud[i];

                if (temp > F || temp < 1) continue;
                if (v[temp]) continue;

                q.add(new elev(temp, t.c + 1));
                v[temp] = true;
            }
        }
        return -1;
    }
}
class elev{
    int n;
    int c;

    elev(int n, int c){
        this.n = n;
        this.c = c;
    }
}