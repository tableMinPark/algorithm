import java.io.*;

public class p1676{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int two = 0;
        int five = 0;
        for (int next = 2; next <= N; next++){
            int now = next;
            while (now % 2 == 0){
                two++;
                now /= 2;
            }
            while (now % 5 == 0){
                five++;
                now /= 5;
            }
        }

        System.out.println(two > five ? five : two);
        br.close();
    }
}