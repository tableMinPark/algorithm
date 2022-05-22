package p5_22;

import java.io.*;
import java.util.*;

public class s1220 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					arr[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			
			// N극 기준
			for (int x = 0; x < N; x++) {
				boolean downExist = false;
				for (int y = 0; y < N; y++) {
					if (arr[y][x] == 0) continue;
					
					// 내려가는 것이 있으면 true
					if (arr[y][x] == 1) downExist = true;
					
					// 내려가는 것이 있고 올라가는 것이 존재하면 하나의 교착상태이므로 아래로 내려가는 것(여러개일수도 있음) 과 올라가는 것 (하나의 S)을 하나의 교착상태로 묶음
					// (F의 경우 각각 다른 교착상태로 판단하여 2개의 교착상태로 본다.)
					if (arr[y][x] == 2 && downExist) {
						downExist = false;
						answer++;
					}
				}
			}
			
			// S극 기준
//			for (int x = 0; x < N; x++) {
//				boolean upExist = false;
//				for (int y = N - 1; y >= 0; y--) {
//					if (arr[y][x] == 0) continue;
//					
//					// 올라가는 것이 있으면 true
//					if (arr[y][x] == 2) upExist = true;					
//					if (arr[y][x] == 1 && upExist) {
//						upExist = false;
//						answer++;
//					}
//				}
//			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
}

