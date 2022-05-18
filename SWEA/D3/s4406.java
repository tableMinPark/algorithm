import java.io.*;

public class s4406 {
    static char[] mo = {'a', 'e', 'i', 'o', 'u'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            char[] str = br.readLine().toCharArray();

            sb.append("#").append(t).append(" ");
            for (char s : str){
                if (check(s)) sb.append(s);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean check(char ch){
        for (char m : mo){
            if (m == ch) return false;
        }
        return true;
    }
}