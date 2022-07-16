package p5_20;

import java.io.*;
import java.util.*;

// 시간초과 심각
public class s5293 {
	static String answer;
	
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
			
			answer = null;
            solve("0", A, B, C, D);
            solve("1", A, B, C, D);
            			
			sb.append("#").append(t).append(" ").append(answer == null ? "impossible" : answer).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void solve(String bits, int A, int B, int C, int D) {
        if( answer != null ) return;							// 아래의 중단조건이 필요함 (시간이 빡빡함)
        if (B - C > 1 || C - B > 1) return;
        if( A < 0 || B < 0 || C < 0 || D < 0 ) return;
		if( A == 0 && B == 0 && C == 0 && D == 0 ) {
			answer = bits;
            return;
        }
		if (bits.substring(bits.length() - 1).equals("0")) {		// 가장 마지막 글자를 분리 - ex) 0101 -> 1, 0100 -> 0
			solve(bits + "0", A - 1, B, C, D);
			solve(bits + "1", A, B - 1, C, D);
			return;
		}
		solve(bits + "0", A, B, C - 1, D);
		solve(bits + "1", A, B, C, D - 1);				
	}
}