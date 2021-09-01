import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p11723{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        boolean[] n = new boolean[20];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()){
                case "add":
                    n[Integer.parseInt(st.nextToken()) - 1] = true;
                    break;
                case "remove":
                    n[Integer.parseInt(st.nextToken()) - 1] = false;
                    break;
                case "check":
                    if (n[Integer.parseInt(st.nextToken()) - 1]) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                    break;
                case "toggle":
                    int idx = Integer.parseInt(st.nextToken()) - 1;
                    n[idx] = !n[idx];
                    break;
                case "all":
                    for (int j = 0; j < 20; j++) n[j] = true;
                    break;
                case "empty":
                    for (int j = 0; j < 20; j++) n[j] = false;
                    break;
            }
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}