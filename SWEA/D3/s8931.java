package d_3;

import java.io.*;
import java.util.*;

public class s8931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());
			
			Stack<Integer> stack = new Stack<>();
			
			for (int i = 0; i < K; i++) {
				int N = Integer.parseInt(br.readLine());				
				if (N != 0) stack.add(N);
				else stack.pop();
			}
			
			int answer = 0;
			while(!stack.isEmpty()) answer += stack.pop();
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
}
