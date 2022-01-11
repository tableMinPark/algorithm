import java.io.*;
import java.util.*;

public class p2250 {
    static int N;
    static Node[] tree;
    static int[] count;

    static int[] answer = new int[10001];
    
    static int idx = 0;
    static int maxD = 1;
    static int maxL = 1;

    public static class Node{
        int l;
        int r;
        public Node(int l, int r){
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        tree = new Node[N + 1];
        count = new int[N + 1];
        

        StringTokenizer st;
        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            tree[c] = new Node(l, r);            
            if (c != -1) count[c]++;
            if (l != -1) count[l]++;
            if (r != -1) count[r]++;
        }

        for (int i = 1; i <= N; i++){
            if (count[i] == 1){
                DFS(i, 1);
            }
        }

        bw.write(new StringBuilder().append(maxD).append(" ").append(maxL).toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static void DFS(int n, int depth){
        if (tree[n].l != -1) DFS(tree[n].l, depth + 1);
        idx++;
        if (answer[depth] == 0) answer[depth] = idx;
        else {
            int temp = idx - answer[depth] + 1;
            if (maxL <= temp) {
                maxL = temp;
                maxD = depth;
            }
        }
        if (tree[n].r != -1) DFS(tree[n].r, depth + 1);
    }
}