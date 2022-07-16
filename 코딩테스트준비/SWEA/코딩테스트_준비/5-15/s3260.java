import java.io.*;
import java.util.*;

public class s3260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            char[] A = st.nextToken().toCharArray();
            char[] B = st.nextToken().toCharArray();

            Stack<Integer> maxs = new Stack<>();
            Stack<Integer> mins = new Stack<>();
            Stack<Integer> answer = new Stack<>();

            for (char a : (A.length > B.length ? A : B)) maxs.push(a-'0');
            for (char a : (A.length <= B.length ? A : B)) mins.push(a-'0');

            int upper = 0;
            while(!maxs.isEmpty()){
                int sum = maxs.pop() + upper;                  
                if (!mins.isEmpty()) sum += mins.pop();
                upper = sum / 10;
                answer.push(sum % 10);
            }
            if (upper > 0) answer.push(upper);
            sb.append("#").append(t).append(" ");
            while(!answer.isEmpty()) sb.append(answer.pop());
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}