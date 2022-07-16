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

/*
 * s1
 * 1. 처음엔 반대방향으로 시도 		(1 - p)
 * 2. 1번 뒤집어서 성공			(q)
 * 
 * s2
 * 1. 처음엔 올바른 방향으로 시도 	(p)
 * 2. 인식실패					(1 - q)
 * 3. 뒤집으면 반대방향이기 때문에 무조건 실패
 * 4. 뒤집어서 성공				(q)
*/