import java.io.*;
import java.util.*;

public class p1963{
    public static class Node{
        int n;
        int c;
        public Node(int n, int c){
            this.n = n;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;

        boolean[] prime = new boolean[10000];

        for (int i = 2; i < 10000; i++){
            if (prime[i]) continue;
            for (int j = 2 * i; j < 10000; j += i) prime[j] = true;
        }

        StringBuilder sb = new StringBuilder();

        for (int test = 0; test < testCase; test++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Queue<Node> q = new LinkedList<>();
            boolean[] v = new boolean[10000];
            q.add(new Node(A, 0));
            v[A] = true;

            int answer = -1;

            while(!q.isEmpty()){
                Node now = q.poll();

                if (now.n == B){
                    answer = now.c;
                    break;
                }

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 4; j++){
                        int[] nextList = intToArr(now.n);
                        nextList[j] = i;
                        int next = arrToInt(nextList);

                        if (next < 1000 || prime[next] || v[next]) continue;
                        q.add(new Node(next, now.c + 1));
                        v[next] = true;
                    }
                }
            }
            sb.append(answer == -1 ? "Impossible" : String.valueOf(answer)).append("\n");
        }
        
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
    public static int arrToInt(int[] arr){
        String temp = "";
        for (int a : arr) temp += String.valueOf(a);
        return Integer.parseInt(temp);
    }
    public static int[] intToArr(int number){
        int[] temp = new int[4];
        for (int i = 0; i < 4; i++) temp[i] = String.valueOf(number).charAt(i)-'0';
        return temp;
    }
}