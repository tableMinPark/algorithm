import java.io.*;
import java.util.*;

import javax.swing.text.html.parser.DTD;

public class p19940 {
    public static class Node{
        int t;
        int Dh;
        int Dt;
        int Nt;
        int Do;
        int No;
        public Node(int t, int Dh, int Dt, int Nt, int Do, int No){
            this.t = t;
            this.Dh = Dh;
            this.Dt = Dt;
            this.Nt = Nt;
            this.Do = Do;
            this.No = No;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++){
            int N = Integer.parseInt(br.readLine());

            Queue<Node> q = new LinkedList<>();

            q.add(new Node(0, 0, 0, 0, 0, 0));

            List<Node> answer = new ArrayList<>();

            while(!q.isEmpty()){
                Node now = q.poll();

                if (now.t == N){
                    answer.add(now);
                    continue;
                }

                int Dh = now.t + 60;
                int Dt = now.t + 10;
                int Nt = now.t - 10;
                int Do = now.t + 1;
                int No = now.t - 1;

                q.add(new Node(Dh, now.Dh + 1, now.Dt, now.Nt, now.Do, now.No));
                q.add(new Node(Dt, now.Dh, now.Dt + 1, now.Nt, now.Do, now.No));
                q.add(new Node(Nt, now.Dh, now.Dt, now.Nt + 1, now.Do, now.No));
                q.add(new Node(Do, now.Dh, now.Dt, now.Nt, now.Do + 1, now.No));
                q.add(new Node(No, now.Dh, now.Dt, now.Nt, now.Do, now.No + 1));
            }

            for (Node ans : answer){

                System.out.println(ans.Dh + " " + ans.Dt + " " + ans.Nt + " " + ans.Do + " " + ans.No);
            }
            
        }

        bw.flush();
        br.close();
        bw.close();
    }
}