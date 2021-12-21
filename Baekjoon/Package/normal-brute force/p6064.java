import java.io.*;
import java.util.StringTokenizer;

public class p6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int M, N, x, y, m, n;

        StringBuilder sb = new StringBuilder();

        for (int testCase = 0; testCase < T; testCase++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;

            int answer = -1;            

            for (int i = x; i <= M * N; i += M){
                if (i % N == y) {
                    answer = i + 1;
                    break;
                }
            }
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
/*
10 12 3 9
1 1	    1
2 2	    2
3 3 	3	1
4 4	    4
5 5 	5
6 6	    6
7 7	    7
8 8	    8
9 9	    9
10 10	10
1 11	11
2 12	12
3 1	    13	2	
4 2	    14
5 3	    15
6 4	    16
7 5	    17
8 6	    18
9 7	    19
10 8	20
1 9	    21
2 10	22
3 11	23	3
4 12	24
5 1	    25
6 2	    26
7 3	    27
8 4	    28
9 5	    29
10 6	30
1 7	    31
2 8	    32
3 9	    33	4
*/