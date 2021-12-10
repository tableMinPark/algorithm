import java.io.*;
import java.util.*;

public class p10437 {

    public static class P implements Comparable<P>{
        int idx;
        float y;
        float x;
        float c;
        public P(int idx, float y, float x, float c){
            this.idx = idx;
            this.y = y;
            this.x = x;
            this.c = c;
        }
        @Override
        public int compareTo(P p){
            if (this.c < p.c) return -1;
            else if (this.c == p.c) return 0;
            else return 1;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());        
        P start = new P(-1, Float.parseFloat(st.nextToken()), Float.parseFloat(st.nextToken()), 0);
        
        st = new StringTokenizer(br.readLine());
        P end = new P(0, Float.parseFloat(st.nextToken()), Float.parseFloat(st.nextToken()), 0);

        int N = Integer.parseInt(br.readLine());
        Float[] value = new Float[N + 1];
        
        PriorityQueue<P> q = new PriorityQueue<>();

        List<P> map = new ArrayList<>();
        value[0] = getDistance(start, end) / 5;
        end.c = value[0];
        map.add(end);
        q.add(end);

        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            P canon = new P(i, Float.parseFloat(st.nextToken()), Float.parseFloat(st.nextToken()), 0);     
            value[i] = getDistance(start, canon) / 5;
            canon.c = value[i];
            map.add(canon);
            q.add(canon);
        }

        while(!q.isEmpty()){
            P p = q.poll();

            for (int i = 0; i <= N; i++){
                if (i == p.idx) continue;
                Float workTime = getDistance(p, map.get(i)) / 5;
                Float canonTime = 2 + Math.abs(getDistance(p, map.get(i)) - 50) / 5;
                Float minTime = Math.min(workTime, canonTime);
                if (minTime + p.c < value[i]){
                    value[i] = minTime + p.c;
                    q.add(new P(i, map.get(i).y, map.get(i).x, minTime + p.c));
                }
            }
        }

        bw.write(String.valueOf(value[0]));
        br.close();
        bw.flush();
        bw.close();
    }

    public static Float getDistance(P s, P e){
        Float Y = (float) Math.pow(s.y - e.y, 2);
        Float X = (float) Math.pow(s.x - e.x, 2);
        return (float) Math.sqrt(Y + X);
    }
}
