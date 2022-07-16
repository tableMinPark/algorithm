import java.io.*;
import java.util.*;

public class p1991 {
    static int N;
    static Map<Character, Node> graph = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static class Node{
        char l;
        char r;
        public Node(char l, char r){
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            graph.put(input[0].charAt(0), new Node(input[1].charAt(0), input[2].charAt(0)));
        }

        First('A');
        sb.append("\n");
        Center('A');
        sb.append("\n");
        End('A');

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static void First(char parent){
        sb.append(parent);
        Node child = graph.get(parent);
        if (child.l != '.') First(child.l);
        if (child.r != '.') First(child.r);
    }
    public static void Center(char parent){
        Node child = graph.get(parent);
        if (child.l != '.') Center(child.l);
        sb.append(parent);
        if (child.r != '.') Center(child.r);
    }
    public static void End(char parent){
        Node child = graph.get(parent);
        if (child.l != '.') End(child.l);
        if (child.r != '.') End(child.r);
        sb.append(parent);
    }
}