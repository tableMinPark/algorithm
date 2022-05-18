import java.io.*;

public class s1215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++){
            int L = Integer.parseInt(br.readLine());

            char[][] arr = new char[8][8];
            for (int i = 0; i < 8; i++) arr[i] = br.readLine().toCharArray();

            int answer = 0;
            for (int y = 0; y < 8; y++){
                for (int x = 0; x <= 8 - L; x++){
                    String str1 = "";
                    String str2 = "";
                    for (int i = x; i < x + L; i++){
                        str1 += arr[y][i];
                        str2 += arr[i][y];
                    }
                    if (check(str1)) answer++;
                    if (check(str2)) answer++;
                }       
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean check(String str){
        for (int i = 0, j = str.length() - 1; i < str.length(); i++, j--){
            if (str.charAt(i) != str.charAt(j)) return false;
        }
        return true;
    }
}