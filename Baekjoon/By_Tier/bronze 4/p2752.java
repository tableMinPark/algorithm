import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] n = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++){
            n[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(n);        
        for(int i = 0; i < 3; i++){
            bw.write(n[i] + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

/*
출력 시 하나의 write를 통해 3수를 한번에 출력하는 것보다는
for문을 통해 출력하는 것이 빠르다
*/