package p5_24_2;

import java.io.*;
import java.util.*;

public class s6692 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			double answer = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				double p = Double.parseDouble(st.nextToken());
				double x = Double.parseDouble(st.nextToken());
				
				answer += p * x;
			}
			
			sb.append("#").append(t).append(" ").append(String.format("%.6f", answer)).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
}
