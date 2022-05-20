package d_3;

import java.io.*;
import java.util.*;

public class s1208 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) arr[i] = Integer.parseInt(st.nextToken());

			int min = Integer.MAX_VALUE, minIdx;
			int max = 0, maxIdx;
			for (int i = 0; i < N; i++) {
				min = Integer.MAX_VALUE;
				minIdx = 0;
				max = 0;
				maxIdx = 0;								
				for (int j = 0; j < 100; j++) {
					if (arr[j] < min) {
						min = arr[j];
						minIdx = j;
					}
					if (arr[j] > max) {
						max = arr[j];
						maxIdx = j;
					}
				}		
				arr[minIdx]++;
				arr[maxIdx]--;

				min = Integer.MAX_VALUE;
				max = 0;
				for (int j = 0; j < 100; j++) {
					max = Math.max(max, arr[j]);
					min = Math.min(min, arr[j]);
				}

				if (max - min <= 1) break; 
			}
			
			sb.append("#").append(t).append(" ").append(max - min).append("\n");
			
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
}
