import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class p3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> r = new HashSet<>();
        for (int i = 0; i < 10; i++) r.add(Integer.parseInt(br.readLine()) % 42);
        bw.write(Integer.toString(r.size()));
        bw.flush();
        br.close();
        bw.close();
    }
}
