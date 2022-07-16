import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1920 {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        A = new int[c];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) A[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A);

        StringBuilder sb = new StringBuilder();

        c = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++){
            if (search(Integer.parseInt(st.nextToken()))) sb.append("1").append("\n");
            else sb.append("0").append("\n");            
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean search(int n){
        int lo = 0;
        int hi = A.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if (A[mid] == n){
                return true;
            }
            else if (A[mid] > n) hi = mid - 1;
            else if (A[mid] < n) lo = mid + 1;
        }
        return false;
    }
}
/**
 * search 함수 while(lo <= hi) 를 사용해서 검색범위의 첫번째 인덱스가 마지막 인덱스를 넘기지 않을 떄까지 반복해야한다
 *             for (0 : A.length) 를 사용해서 이미 탐색이 끝났는데도 돌아가기 때문에 시간초과가 발생
 * 
 * 이분탐색의 반복조건을 좀 더 생각하면서 설정해야 할 것 같다.
 */