package d_3;

import java.io.*;
import java.util.*;

public class s5515 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[] arr = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int answer = 4;
			for (int i = 0; i < m - 1; i++) answer += arr[i];
			answer += d - 1;
			sb.append("#").append(t).append(" ").append(answer % 7).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
