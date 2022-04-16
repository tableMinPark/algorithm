import java.io.*;
import java.util.*;

public class s1948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int fm = Integer.parseInt(st.nextToken());
            int fd = Integer.parseInt(st.nextToken());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());

            int sum = 0;

            for (int i = fm; i < sm; i++) sum += getDay(i);
            sum -= fd;
            sum += sd + 1;

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static int getDay(int m){
        if (m == 2) return 28;
        else if (m == 4 || m == 6 || m == 9 || m == 11) return 30;
        else return 31;
    }
}