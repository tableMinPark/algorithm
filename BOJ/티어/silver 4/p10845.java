import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        int[] q = new int[10000];
        int size = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    q[size++] = Integer.parseInt(st.nextToken());
                    break;                
                case "pop":
                    if (size == 0) sb.append("-1").append("\n");
                    else{
                        sb.append(q[0]).append("\n");
                        for (int j = 1; j < size; j++) q[j - 1] = q[j];
                        size--;
                    }             
                    break;
                case "size":
                    sb.append(size).append("\n");
                    break;                
                case "empty":
                    if (size == 0) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                    break;
                case "front":
                    if (size == 0) sb.append("-1").append("\n");
                    else sb.append(q[0]).append("\n");
                    break;
                
                case "back":                    
                    if (size == 0) sb.append("-1").append("\n");
                    else sb.append(q[size - 1]).append("\n");
                    break;
            }
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
