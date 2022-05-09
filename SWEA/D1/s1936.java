import java.io.*;
import java.util.*;

public class s1936 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] answer = {0, 2, 3, 1};

        if (answer[A] == B) bw.write("B");
        else bw.write("A");

        br.close();
        bw.flush();
        bw.close();
    }
}