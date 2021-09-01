import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class p11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> n = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) n.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) n.add(Integer.parseInt(st.nextToken()));
        Collections.sort(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N + M; i++) sb.append(n.get(i)).append(" ");
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
//정렬이 되어있는 두 배열을 받는다.