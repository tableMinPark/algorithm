import java.io.*;
import java.util.*;

public class p17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = br.readLine().toCharArray();
        Stack<Character> s = new Stack<Character>();

        StringBuilder sb = new StringBuilder();
        boolean check = false;

        for (char c : arr) {
            switch (c){
                case '<': 
                    while (!s.isEmpty()) sb.append(s.pop());
                    sb.append('<');
                    check = true;
                    continue;
                case '>':         
                    sb.append('>');
                    check = false;
                    continue;                
                case ' ':                  
                    while (!s.isEmpty()) sb.append(s.pop());     
                    sb.append(' ');
                    continue;
                default:
                    if (!check) {
                        s.push(c);
                        continue;
                    } else {
                        sb.append(c);
                        continue;
                    }
            }
        }
        while (!s.isEmpty()) sb.append(s.pop());

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}