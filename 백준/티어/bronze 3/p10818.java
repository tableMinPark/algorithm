import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            int t = Integer.parseInt(st.nextToken());
            if (t > max){
                max = t;
            }
            if (t < min){
                min = t;
            }
        }
        bw.write(Integer.toString(min) + " " + Integer.toString(max));
        bw.flush();
        br.close();
        bw.close();
    }
    
}
/*
최대값 - 최소값 구하는 연산시 Arrays.sort()를 사용하면 시간이 2배 이상 걸린다.
for문과 if를 사용해 max - min 비교하는 것이 가장빠르다.

sort 사용시 - 104716 KB / 1484 ms
for + if사용시 - 88420 KB / 516 ms
*/