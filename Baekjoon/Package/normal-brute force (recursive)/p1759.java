import java.io.*;
import java.util.*;

public class p1759 {
    static int L, C;
    static char[] ch;
    static boolean[] v;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        ch = new char[C];
        v = new boolean[C];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) ch[i] =  st.nextToken().charAt(0);
        Arrays.sort(ch);

        DFS(0, 0);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int idx, int depth){
        if (depth == L){
            if (check()){
                for (int i = 0; i < C; i++) {
                    if (v[i]) sb.append(ch[i]);
                }
                sb.append("\n");
            }
            return;
        }
        for (int i = idx; i < C; i++){
            v[i] = true;
            DFS(i + 1, depth + 1);
            v[i] = false;
        }
    }
    public static boolean check(){
        int m = 0;
        for (int i = 0; i < C; i++){
            if (!v[i]) continue;
            char t = ch[i];
            if (t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u') m++;
        }
        if (m >= 1 && L - m >= 2) return true;
        return false;
    }
}