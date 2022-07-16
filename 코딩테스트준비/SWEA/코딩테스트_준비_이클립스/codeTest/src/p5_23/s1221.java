package p5_23;

import java.io.*;
import java.util.*;

public class s1221 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			String tc = st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				String n = st.nextToken();
				
				switch(n) {
				case "ZRO":
					arr[i] = 0;
					break;
				case "ONE":
					arr[i] = 1;
					break;
				case "TWO":
					arr[i] = 2;
					break;
				case "THR":
					arr[i] = 3;
					break;
				case "FOR":
					arr[i] = 4;
					break;
				case "FIV":
					arr[i] = 5;
					break;
				case "SIX":
					arr[i] = 6;
					break;
				case "SVN":
					arr[i] = 7;
					break;
				case "EGT":
					arr[i] = 8;
					break;
				case "NIN":
					arr[i] = 9;
					break;
				}
			}
			
			Arrays.sort(arr);
			
			String[] str = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
			
			sb.append(tc).append("\n");
			for (int i = 0; i < N; i++) sb.append(str[arr[i]]).append(" ");
			sb.append("\n");
			
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
}
