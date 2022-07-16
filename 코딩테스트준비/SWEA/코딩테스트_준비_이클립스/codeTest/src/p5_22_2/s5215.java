package p5_22_2;

import java.io.*;
import java.util.*;

public class s5215 {
	static int N, L;
	static int[][] arr;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			arr = new int[N][2];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			answer = 0;
			DFS(0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");			
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void DFS(int score, int cal, int depth) {
		if (cal > L) return;
		else answer = Math.max(answer, score);
		if (depth == N) return;
		
		DFS(score + arr[depth][0], cal + arr[depth][1], depth + 1);
		DFS(score, cal, depth + 1);
	}
}


// ´Ù½Ã