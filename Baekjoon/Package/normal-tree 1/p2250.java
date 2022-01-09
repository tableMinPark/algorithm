import java.io.*;
import java.util.*;

public class p2250 {
    static int N;
    static Node[] tree;
    static List<Node> answer;
    static int maxD = 1;
    static int maxL = 0;


    public static class Node{
        int c;
        int l;
        int r;
        int d;
        public Node(int c, int l, int r, int d){
            this.c = c;
            this.l = l;
            this.r = r;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        tree = new Node[N + 1];
        answer = new ArrayList<>();

        StringTokenizer st;
        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            tree[c] = new Node(c, l, r, 0);
        }

        DFS(1, 1);

        StringBuilder sb = new StringBuilder();
        List<Node>[] arr = new ArrayList[maxD + 1];
        for (int i = 1; i <= maxD; i++) arr[i] = new ArrayList<>();
        for (Node n : answer) arr[n.d].add(n);
        for (int i = 1; i <= maxD; i++){
            int A = arr[i].get(0).c;
            int B = arr[i].get(arr[i].size() - 1).c;
            int sum = B - A + 1;
            if (maxL < sum){
                maxL = sum;
                sb = new StringBuilder();
                sb.append(i).append(" ").append(sum);
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
    public static void DFS(int parent, int depth){
        maxD = Math.max(depth, maxD);
        if (tree[parent].l != -1) DFS(tree[parent].l, depth + 1);
        answer.add(new Node(answer.size(), tree[parent].l, tree[parent].r, depth));
        if (tree[parent].r != -1) DFS(tree[parent].r, depth + 1);
    }
}