import java.io.*;
import java.util.*;

public class p13549{
    public static class P{
        int point;
        int time;

        public P(int point, int time){
            this.point = point;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] v = new boolean[100001];

        Queue<P> q = new LinkedList<>();
        q.add(new P(N, 0));
        v[N] = true;

        int answer = 0;

        while(!q.isEmpty()){
            P p = q.poll();

            if (p.point == K){
                answer = p.time;
                break;
            }

            int n1 = p.point - 1;
            int n2 = p.point + 1;
            int n3 = p.point * 2;

            if (n3 <= 100000 && !v[n3]){            //수정후 위치(틀린이유는 아래 주석 확인)
                v[n3] = true;
                q.add(new P(n3, p.time));
            }
            if (n1 >= 0 && !v[n1]){
                v[n1] = true;
                q.add(new P(n1, p.time + 1));
            }
            if (n2 <= 100000 && !v[n2]){
                v[n2] = true;
                q.add(new P(n2, p.time + 1));
            }
            /*
            if (n3 <= 100000 && !v[n3]){            //수정전 위치(틀린이유는 아래 주석 확인)
                v[n3] = true;
                q.add(new P(n3, p.time));
            }
            */
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }
}
//참고한 질문 > https://www.acmicpc.net/board/view/66290
//입력이 1 2 일 때 1 * 2 = 2 와 1 + 1 = 2 의 상황이 있는데 최단 시간이기 때문에 * 2 의 순서가 먼저와야함