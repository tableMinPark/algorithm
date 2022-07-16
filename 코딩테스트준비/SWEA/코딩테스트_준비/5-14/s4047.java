import java.io.*;

public class s4047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            char[] str = br.readLine().toCharArray();

            int[][] arr = new int[4][13];
            boolean check = true;

            sb.append("#").append(t);

            for (int i = 0; i < str.length; i += 3){
                char ch = str[i];
                int n = ((str[i + 1]-'0') * 10) + (str[i + 2]-'0');

                int idx;
                if (ch == 'S') idx = 0;
                else if (ch == 'D') idx = 1;
                else if (ch == 'H') idx = 2;
                else idx = 3;

                if (arr[idx][n - 1] == 0) arr[idx][n - 1]++;
                else {
                    sb.append(" ERROR");
                    check = false;
                    break;
                }
            }

            if (check){
                for (int i = 0; i < 4; i++){
                    int sum = 0;
                    for (int j = 0; j < 13; j++){
                        sum += arr[i][j];
                    }
                    sb.append(" ").append(13 - sum);
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