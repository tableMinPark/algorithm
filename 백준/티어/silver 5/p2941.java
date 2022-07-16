import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2941 {
    static char[] ch = {'=', '-', 'j'};
    static char[] e = {'c', 'z', 's'};
    static char[] m = {'c', 'd'};
    static char[] j = {'n', 'l'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer(br.readLine());
        String s = sb.reverse().toString();

        int count = 0;

        if (s.length() < 2)
            count = 1;
        else{
            for (int i = 0; i < s.length(); i++){
                char a = s.charAt(i);
                if (check(a, ch)){
                    if (a == '='){
                        if (i + 1 < s.length() && check(s.charAt(i + 1), e)){
                            i++;
                            if (i + 1 < s.length() && s.charAt(i + 1) == 'd' && s.charAt(i) == 'z') 
                                i++;
                        }
                    }
                    else if (a == '-'){
                        if (i + 1 < s.length() && check(s.charAt(i + 1), m)) i++;
                    }
                    else if (a == 'j'){
                        if (i + 1 < s.length() && check(s.charAt(i + 1), j)) i++;
                    }
                }
                count++;
            }
        }

        bw.write(Integer.toString(count));

        
        bw.flush();
        br.close();
        bw.close();
    }
    public static boolean check(char w, char[] wl){
        for (int i = 0; i < wl.length; i++) if (wl[i] == w) return true;
        return false;
    }
}
