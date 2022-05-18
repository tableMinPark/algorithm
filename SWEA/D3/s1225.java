import java.io.*;
import java.util.*;

public class s1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 1; t++){
            int T = Integer.parseInt(br.readLine());

            Queue<Integer> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) q.add(Integer.parseInt(st.nextToken()));

    LOOP:   while(true){
                for (int i = 1; i <= 5; i++){
                    int sum = q.poll() - i;
                    if (sum <= 0){
                        q.add(0);
                        break LOOP;
                    }
                    q.add(sum);
                }
            }

            sb.append("#").append(T).append(" ");
            while(!q.isEmpty()) sb.append(q.poll()).append(" ");
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}

// 10개의 테스트케이스 명시안되있음.
// "숫자가 감소할 때 0보다 작아지는 경우 0으로 유지되며, 프로그램은 종료된다." 라고 되어있어 음수가 되면 종료
// 라고 생각했지만, 0일 경우도 종료되어야한다.