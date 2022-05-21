package p5_21;

import java.io.*;
import java.util.*;

public class s8104 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] answer = new int[K + 1];
			
			int s = 1;
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					for (int j = 1; j <= K; j++) {
						answer[j] += s++;
					}
				}
				else {
					for (int j = K; j >= 1; j--) {
						answer[j] += s++;
					}
				}
			}
			
			sb.append("#").append(t);
			for (int i = 1; i <= K; i++) sb.append(" ").append(answer[i]);
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
}
