package d_3;

import java.io.*;
import java.util.*;

public class s9700 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			double p = Double.parseDouble(st.nextToken());
			double q = Double.parseDouble(st.nextToken());
			
			double s1 = (1 - p) * q;
			double s2 = p * (1 - q) * q;
			
			sb.append("#").append(t).append(" ").append(s1 < s2 ? "YES" : "NO").append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}

// 다시보기
