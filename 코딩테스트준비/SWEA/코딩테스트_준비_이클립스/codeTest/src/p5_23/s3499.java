package p5_23;

import java.io.*;
import java.util.*;

public class s3499 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2 + (N % 2 == 0 ? 0 : 1); i++) q1.add(st.nextToken());
			for (int i = 0; i < N - q1.size(); i++) q2.add(st.nextToken());
			
			sb.append("#").append(t);
			while(!q1.isEmpty()) {
				sb.append(" ").append(q1.poll());
				if (!q2.isEmpty()) sb.append(" ").append(q2.poll());
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
}
