import java.io.*;

public class s1216 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++){
            int T = Integer.parseInt(br.readLine());

            char[][] arr = new char[100][100];

            for (int y = 0; y < 100; y++){
                arr[y] = br.readLine().toCharArray();
            }

            int answer = 1;
            for (int y = 0; y < 100; y++){
                for (int x = 0; x < 100; x++){
                    for (int i = 1; i <= 100 - x; i++){
                        String str1 = "";
                        String str2 = "";
                        for (int next = x; next < x + i; next++){
                            str1 += arr[y][next];
                            str2 += arr[next][y];
                        }
                        if (check(str1)) answer = Math.max(answer, i);
                        if (check(str2)) answer = Math.max(answer, i);
                    }
                }
            }
            sb.append("#").append(T).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean check(String str){
        for (int f = 0, r = str.length() - 1; f < str.length() / 2 + (str.length() % 2 == 0 ? 0 : 1); f++, r--){
            if (str.charAt(f) != str.charAt(r)){
                return false;
            }
        }
        return true;
    }
}