package p5_22;

import java.io.*;
import java.util.*;

public class s1206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
			
			int answer = 0;			
			for (int i = 2; i < N - 2; i++) {
				int fm = Math.max(arr[i - 2], arr[i - 1]);
				int rm = Math.max(arr[i + 1], arr[i + 2]);
				
				int max = Math.max(fm, rm);
				answer += arr[i] - max > 0 ? arr[i] - max : 0;
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString());		
		br.close();
		bw.flush();
		bw.close();
	}
	
}
