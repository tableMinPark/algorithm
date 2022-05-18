import java.io.*;

public class s1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++){
            int T = Integer.parseInt(br.readLine());

            String str = br.readLine();
            char[] arr = br.readLine().toCharArray();

            int answer = 0;
            for (int i = 0; i <= arr.length - str.length(); i++){
                String temp = "";
                for (int j = i; j < i + str.length(); j++) temp += arr[j];
                if (temp.equals(str)) answer++;
            }

            sb.append("#").append(T).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}