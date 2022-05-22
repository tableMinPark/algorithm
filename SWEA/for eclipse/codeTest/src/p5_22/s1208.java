package p5_22;

import java.io.*;
import java.util.*;

public class s1208 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int MAX_LENGTH = 10;
		
		for (int t = 1; t <= 1; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[MAX_LENGTH];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < MAX_LENGTH; i++) arr[i] = Integer.parseInt(st.nextToken());
			
			int max = 0, min = MAX_LENGTH;
			while(N > 0) {
				// 최대, 최소 찾음
				int midx = 0, nidx = 0;
				max = 0;
				min = MAX_LENGTH;
				for (int i = 0; i < MAX_LENGTH; i++) {
					if (arr[i] > max) {
						max = arr[i];
						midx = i;
					}
					if (arr[i] < min) {
						min = arr[i];
						nidx = i;
					}
				}				
				
				// 덤프
				arr[midx]--;
				arr[nidx]++;
				N--;
				
				// 덤프 후 최대 최소 찾음
				max = 0;
				min = MAX_LENGTH;
				for (int i = 0; i < MAX_LENGTH; i++) {
					max = Math.max(max, arr[i]);
					min = Math.min(min, arr[i]);
				}				
				
				if (max - min <= 1) {
					break;
				}				
			}
			sb.append("#").append(t).append(" ").append(max - min).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
}
