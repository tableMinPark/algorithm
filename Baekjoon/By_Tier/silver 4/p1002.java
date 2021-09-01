import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            if (x1 == x2 && y1 == y2 && r1 == r2) sb.append("-1");
            else {
                int d = ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2- y1));
                if (d > (r1 + r2) * (r1 + r2)) sb.append("0");
                else if (d < (r2 - r1) * (r2 - r1))  sb.append("0");
                else if (d == (r2 - r1) * (r2 - r1))  sb.append("1");
                else if (d == (r2 + r1) * (r2 + r1))  sb.append("1");
                else sb.append("2");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

/*
1. 두 원의 중심이 같고, 반지름도 같을 때 ( 접점의 개수가 무한할 때 )
𝑥₁ = 𝑥₂, 𝑦₁ = 𝑦₂, 𝑟₁ = 𝑟₂

2.
 */
