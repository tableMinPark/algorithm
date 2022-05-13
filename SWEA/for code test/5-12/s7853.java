import java.io.*;
import java.util.*;

public class s7853 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            char[] ch = br.readLine().toCharArray();
            
            Set<String> set = new HashSet<>();

            for (int i = 0; i < ch.length; i++){
                int[] next = {i - 1, i, i + 1};

                for (int n : next){
                    if (n < 0 || n >= ch.length){
                        continue;
                    }
                    char temp = ch[i];
                    ch[i] = ch[n];
                    set.add(make(ch));
                    ch[i] = temp;
                }
            }
            for (String s : set) System.out.println(s);

            sb.append("#").append(t).append(" ").append(set.size()).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static String make(char[] ch){
        String temp = "";
        for (int i = 0; i < ch.length; i++) temp += ch[i];
        return temp;
    }
}