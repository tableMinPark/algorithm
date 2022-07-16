package p5_20;

import java.io.*;
import java.util.*;

public class s9280 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] p = new int[n];
			int[] w = new int[m + 1];
			
			for (int i = 0; i < n; i++) p[i] = Integer.parseInt(br.readLine());
			for (int i = 1; i <= m; i++) w[i] = Integer.parseInt(br.readLine());
			
			int[] parking = new int[n];
			
			Queue<Integer> in = new LinkedList<>();

			int answer = 0;
			for (int i = 0; i < m * 2; i++) {
				int car = Integer.parseInt(br.readLine());
				
				// 입차
				if (car > 0) in.add(car);
				// 출차
				else {
					car = car * -1;
					for (int j = 0; j < n; j++) {
						if (parking[j] == car) {
							answer += p[j] * w[car];
							parking[j] = 0;
							break;
						}
					}
				}
				// 자리가 있고, 대기중인 차가 있으면 집어넣는다.
				int idx = count(parking);
				if (idx > -1 && !in.isEmpty()) parking[idx] = in.poll();
			}			
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	public static int count(int[] parking) {
		for (int i = 0; i < parking.length; i++) {
			if (parking[i] == 0) return i;
		}
		return -1;
	}
}
