import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> n = new LinkedList<>();

        for (int i = 0; i < N; i++) n.add(i + 1);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (n.size() > 1) {
            for (int j = 0; j < K - 1; j++) n.add(n.poll());
            sb.append(n.poll()).append(", ");
        }
        sb.append(n.poll()).append(">");
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
