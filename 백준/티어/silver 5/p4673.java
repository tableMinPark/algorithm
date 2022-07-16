import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class p4673 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] c = new boolean[10000];

        for (int i = 1; i < 10000; i++){
            int sn = d(i);

            if (sn < 10000) c[d(i)] = true;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10000; i++) if (!c[i]) sb.append(i + 1).append("\n");

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    public static int d(int n){
        int s = n;

        while (n != 0){
            s += n % 10;
            n = n / 10;
        }
        return s - 1;
    }
}