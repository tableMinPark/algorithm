import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int y = 1;
        int e = 1;
        int s = 1;
        int m = 1;

        while (true){
            if (E == e && S == s && M == m) break;
            y++;
            e++;
            s++;
            m++;
            if (e > 15) e = 1;
            if (s > 28) s = 1;
            if (m > 19) m = 1;
        }
        bw.write(Integer.toString(y));

        bw.flush();
        br.close();
        bw.close();
    }
}

/*
while(true) {
    year++;
    if((year-e)%15 == 0 && (year-s)%28 == 0 && (year-m)%19 == 0) break;
}
*/