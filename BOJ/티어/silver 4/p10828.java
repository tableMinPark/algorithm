import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        int[] s = new int[10000];
        int size = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    s[size++] = Integer.parseInt(st.nextToken());
                    break;
                case "pop":
                    if (size == 0) sb.append("-1");
                    else sb.append(s[--size]);
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(size).append("\n");
                    break;
                case "empty":
                    if (size == 0) sb.append("1");
                    else sb.append("0");
                    sb.append("\n");
                    break;                
                case "top":
                    if (size == 0) sb.append("-1");
                    else sb.append(s[size - 1]);
                    sb.append("\n");
                    break;
            }
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
