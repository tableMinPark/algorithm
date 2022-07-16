import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p2606 {
    static int c;
    static int t;
    static int[][] m;
    static boolean[] v;
    static int count = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        c = Integer.parseInt(br.readLine());
        t = Integer.parseInt(br.readLine());
        m = new int[c + 1][c + 1];

        for (int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            m[a][b] = m[b][a] = 1;
        }
        
        v = new boolean[c + 1];
        DFS(1);
        bw.write(Integer.toString(count));

        bw.flush();
        br.close();
        bw.close();
    }
    public static void DFS(int idx){
        v[idx] = true;
        count++;
        for (int i = 1; i <= c; i++) if (m[idx][i] == 1 && !v[i]) DFS(i);
    }
}
