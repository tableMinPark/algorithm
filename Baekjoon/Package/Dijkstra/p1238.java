//틀렸습니다 - 다익스트라의 개념을 좀 더 숙지후 도전

import java.io.*;
import java.util.*;

public class p1238{
    public static class Node implements Comparable<Node>{
        int n;
        int v;
        public Node(int n, int v){
            this.n = n;
            this.v = v;
        }
        @Override
        public int compareTo(Node n){
            return this.v - n.v;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[N + 1];;
        List<Node>[] reverseGraph = new ArrayList[N + 1];
        int[] values = new int[N + 1];
        int[] reverseValues = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph[n1].add(new Node(n2, value));
            reverseGraph[n2].add(new Node(n1, value));
        }
        
        int answer = 0;

        dijkstra(graph, values, X, N);
        dijkstra(reverseGraph, reverseValues, X, N);

        for (int i = 1; i <= N; i++){
            int sum = values[i] + reverseValues[i];
            if (answer < sum) answer = sum;
        }
        
        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }
    public static void dijkstra(List<Node>[] graph, int[] values, int X, int N){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(X, 0));
        
        for (int i = 1; i <= N; i++) values[i] = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            Node now = q.poll();

            for (int i = 0; i < graph[now.n].size(); i++){
                Node next = graph[now.n].get(i);
                if (values[next.n] > next.v + now.v){
                    values[next.n] = next.v + now.v;
                    q.add(new Node(next.n, next.v + now.v));
                }
            }
        }
    }
}