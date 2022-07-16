import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class p10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> n = new HashSet<>();
        for (int i = 0; i < c; i++) n.add(Integer.parseInt(st.nextToken()));

        List<Integer> nl = new ArrayList<>(n);
        Collections.sort(nl);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n.size(); i++) sb.append(nl.get(i)).append(" ");

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
//StringTokenizer를 대체할 수 있는 다른 방법
//int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();