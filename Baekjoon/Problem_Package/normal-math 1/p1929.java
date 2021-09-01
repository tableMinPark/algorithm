import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1929{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] n = new int[1000001];

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= N; i++) {
            n[i] = i;
        }

        for (int i = 2; i <= N; i++){
            if (n[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= N; j += i){
                n[j] = 0;
            } 
        }
        for (int i = M; i <= N; i++){            
            if (n[i] != 0) sb.append(i).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
/**
 * 에라토스 테네스의 체 예제
 * https://blog.naver.com/PostView.naver?blogId=ndb796&logNo=221233595886&redirect=Dlog&widgetTypeCall=true&directAccess=false
 */