package d_3;

import java.io.*;

public class s8821 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			char[] arr = br.readLine().toCharArray();
			boolean[] v = new boolean[10];
			
			for (char a : arr) {
				if (v[a-'0']) v[a-'0'] = false;
				else v[a-'0'] = true;
			}
			
			int answer = 0;			
			for (int i = 0; i < 10; i++) {
				if (v[i]) answer++;
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
}
