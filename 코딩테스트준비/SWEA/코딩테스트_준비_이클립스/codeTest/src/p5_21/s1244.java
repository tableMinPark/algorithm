package p5_21;

import java.io.*;
import java.util.*;

public class s1244 {
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			char[] arr = st.nextToken().toCharArray();
			int cnt = Integer.parseInt(st.nextToken());
			
			if (arr.length < cnt) cnt = arr.length;
			
			answer = 0;
			DFS(arr, cnt, 0);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void DFS(char[] arr, int cnt, int start) {
		if (cnt == 0) {
			System.out.println(start + " " + cnt + " " + String.valueOf(arr));
			answer = Math.max(answer, Integer.parseInt(String.valueOf(arr)));
			return;
		}
		
		for (int i = start; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				char stri = arr[i];
				char strj = arr[j];
				
				arr[i] = strj;
				arr[j] = stri;
				DFS(arr, cnt - 1, i);		// cnt 가  0이 될때까지 같은 자리만 반복해서 바꿈
				arr[i] = stri;
				arr[j] = strj;								
			}
		}
	}
}
