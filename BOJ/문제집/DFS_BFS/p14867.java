import java.io.*;
import java.util.*;

public class p14867 {
    public static class bottle{
        int a;
        int b;
        int c;
        public bottle(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
        @Override
        public boolean equals(Object b){
            if (this == b)
                return true;
            if (!(b instanceof bottle))
                return false;
            bottle bo = (bottle) b;
            return this.a == bo.a && this.b == bo.b;           
        }
        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    static int A;
    static int B;
    static int eA;
    static int eB;
    static Queue<bottle> q;
    static HashSet<bottle> v;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        eA = Integer.parseInt(st.nextToken());
        eB = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        v = new HashSet<>();

        q.add(new bottle(0, 0, 0));
        v.add(new bottle(0, 0, 0));

        BFS();

        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }

    public static void BFS(){
        while(!q.isEmpty()){
            bottle now = q.poll();

            if (now.a == eA && now.b == eB) {
                answer = now.c;
                return;
            }

            List<bottle> temp = new ArrayList<>();

            temp.add(new bottle(A, now.b, now.c + 1));
            temp.add(new bottle(0, now.b, now.c + 1));
            int tempA = now.a + now.b > B ? now.a + now.b - B : 0;
            int tempB = now.a + now.b > B ? B : now.a + now.b;
            temp.add(new bottle(tempA, tempB, now.c + 1));

            temp.add(new bottle(now.a, B, now.c + 1));
            temp.add(new bottle(now.a, 0, now.c + 1));
            tempA = now.a + now.b > A ? A : now.a + now.b;
            tempB = now.a + now.b > A ? now.a + now.b - A : 0;
            temp.add(new bottle(tempA, tempB, now.c + 1));

            for (int i = 0; i < temp.size(); i++){
                bottle next = temp.get(i);
                if (v.contains(next)) continue;
                q.add(next);
                v.add(next);
            }
        }
    }
}
