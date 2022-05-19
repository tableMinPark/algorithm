package p5_19;

import java.io.*;
import java.util.*;

/*
 * 두 개의 전구 X와 Y가 있다. 당신은 0초에서부터 시작하여 100초간 두 전구가 언제 켜지는지를 관찰하였다.
  관찰 결과, 전구 X는 관찰 시작 경과 후 A초에서부터 관찰 시작 경과 후 B초까지에만 켜져 있었다. 전구 Y는 관찰 시작 경과 후 C초에서부터 관찰 시작 경과 후 D초까지에만 켜져 있었다.
  당신이 두 전구를 관찰하던 100초 중 두 전구가 동시에 켜져 있던 시간은 몇 초일까?  
*/

public class s12741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	int C = Integer.parseInt(st.nextToken());
        	int D = Integer.parseInt(st.nextToken());
        	
        	boolean[] x = new boolean[101];
        	boolean[] y = new boolean[101];
        	
        	
        	int answer = 0;
        	for (int i = A; i < B; i++) x[i] = true;
        	for (int i = C; i < D; i++) y[i] = true;
        	for (int i = 0; i <= 100; i++) {
        		if (x[i] && y[i]) answer++;
        	}
        	sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        
        bw.write(sb.toString());        
        br.close();
        bw.flush();
        bw.close();
    }
}