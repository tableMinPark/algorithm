import java.io.*;
import java.util.*;

public class s1928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, w = 'A'; i < 26; i++, w++) map.put((char) w, i);
        for (int i = 26, w = 'a'; i < 52; i++, w++) map.put((char) w, i);
        for (int i = 52, w = '0'; i < 64; i++, w++) map.put((char) w, i);
        map.put('+', 62);
        map.put('/', 63);

        for (int t = 1; t <= T; t++){
            char[] str = br.readLine().toCharArray();

            sb.append("#").append(t).append(" ");

            for (int i = 0; i < str.length; i += 4){
                String binary = "";
                for (int j = i; j < i + 4; j++){
                    binary += String.format("%6s", Integer.toBinaryString(map.get(str[j]))).replace(" ", "0");
                }

                for (int j = 0; j < 24; j += 8){
                    String temp = "";
                    for (int k = j; k < j + 8; k++) temp += binary.charAt(k);
                    sb.append((char) Integer.parseInt(temp, 2));
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}