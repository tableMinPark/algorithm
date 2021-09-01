import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1018 {
    static char[][] b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        b = new char[N][M];

        for (int i = 0; i < N; i++) b[i] = br.readLine().toCharArray();
        
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N - 7; i++){
            for (int j = 0; j < M - 7; j++){
                int count = check(i, j);
                if (count < min) min = count;
            }
        }        
        bw.write(Integer.toString(min));
        bw.flush();
        br.close();
        bw.close();
    }

    public static int check(int y, int x){
        int c1 = 0;
        char p = 'W';
        for (int i = y; i < 8 + y; i++){
            for (int j = x; j < 8 + x; j++){
                if (p == b[i][j]) c1++;
                p = p == 'W' ? 'B' : 'W';
            }            
            p = p == 'W' ? 'B' : 'W';
        }  

        int c2 = 0;
        p = 'B';
        for (int i = y; i < 8 + y; i++){
            for (int j = x; j < 8 + x; j++){
                if (p == b[i][j]) c2++;
                p = p == 'W' ? 'B' : 'W';
            }            
            p = p == 'W' ? 'B' : 'W';
        }  
        return c1 < c2 ? c1 : c2;
    }
}
//(0, 0)의 색이 'W' 인 경우와 'B' 인 경우로 나누어서 두번 탐색해야한다.
