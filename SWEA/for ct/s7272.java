import java.io.*;
import java.util.*;

public class s7272 {
    static char[][] arr = {{'C','E','F','G','H','I','J','K','L','M','N','S','T','U','V','W','X','Y','Z'}, {'A','D','O','P','Q','R'}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            char[] A = st.nextToken().toCharArray();
            char[] B = st.nextToken().toCharArray();

            sb.append("#").append(t).append(" ");

            boolean isSame = true;

            if (A.length == B.length){
                for (int i = 0; i < A.length; i++){
                    if (check(A[i]) != check(B[i])){
                        isSame = false;
                        break;
                    }
                }
            } else isSame = false;

            if (isSame) sb.append("SAME");
            else sb.append("DIFF");
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
    public static int check(char c){
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j] == c) return i;
            }
        }
        return 2;
    }
}