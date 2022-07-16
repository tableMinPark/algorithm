import java.io.*;
import java.util.*;

public class s1234 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 1; t <= 10; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            
            char[] input = st.nextToken().toCharArray();
            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < N; i++) arr.add(input[i]-'0');

            int cnt = 0;
            
            while(true){
                if (cnt == arr.size() - 1) break;
                for (int i = 1; i < arr.size(); i++){
                    if (arr.get(i) == arr.get(i - 1)){
                        arr.remove(i);
                        arr.remove(i - 1);
                        cnt = 0;
                        break;
                    } else cnt++;
                }
            }

            sb.append("#").append(t).append(" ");
            for (int a : arr) sb.append(a);
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}