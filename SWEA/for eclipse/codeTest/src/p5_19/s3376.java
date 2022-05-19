package p5_19;

import java.io.*;
import java.util.*;

/*
 * P1에서 P10까지를 순서대로 나열하면 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.
 N이 주어질 때 PN을 구하는 프로그램을 작성하라.
*/

public class s3376 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= T; t++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	List<Long> arr = new ArrayList<>();
        	arr.add(1L);
        	arr.add(1L);
        	arr.add(1L);
        	
        	for (int i = 3; i < N; i++) {
        		arr.add(arr.get(i - 3) + arr.get(i - 2));        		
        	}        	
        	sb.append("#").append(t).append(" ").append(arr.get(N - 1)).append("\n");
        }
        
        bw.write(sb.toString());        
        br.close();
        bw.flush();
        bw.close();
    }
}