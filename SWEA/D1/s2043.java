import java.io.*;
import java.util.*;

public class s2043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int answer = 0;
        if (A > B) answer = A - B + 1;
        else answer = 999 - B + A + 2; 

        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }
}