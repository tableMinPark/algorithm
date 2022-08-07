import java.io.*;

// 덧셈 부분을 먼저 계산한다.
public class p1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sub = br.readLine().split("-");

        int answer = Integer.MAX_VALUE;
        for (String s : sub){
            int sum = 0;
            for (String a : s.split("\\+")){
                sum += Integer.parseInt(a);
            }
            if (answer == Integer.MAX_VALUE) answer = sum;
            else answer -= sum;
        }

        System.out.println(answer);
        br.close();
    }
}
