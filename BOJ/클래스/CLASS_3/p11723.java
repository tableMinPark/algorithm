import java.io.*;
import java.util.*;

public class p11723{

    static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        boolean[] s = new boolean[21];

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            if (!command.equals("all") && !command.equals("empty")) x = Integer.parseInt(st.nextToken());
            
            switch (command){
                case "add":
                    s[x] = true;
                    break;
                case "remove":
                    s[x] = false;
                    break;
                case "check":
                    sb.append(s[x] ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    s[x] = !s[x];
                    break;
                case "all":
                    Arrays.fill(s, true);
                    break;
                case "empty":
                    Arrays.fill(s, false);
                    break;
            }
        }

        System.out.println(sb.toString().trim());
        br.close();
    }
}