package d_3;

import java.io.*;

public class s14361 {
	static char[] arr;
	static boolean[] v;
	static boolean answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			arr = br.readLine().toCharArray();
			
			v = new boolean[arr.length];
			answer = false;
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != '0') {
					v[i] = true;
					DFS(1, String.valueOf(arr[i]));			
					v[i] = false;
				}
			}
			sb.append("#").append(t).append(" ").append(answer ? "possible" : "impossible").append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void DFS(int depth, String n) {
		if (depth == arr.length) {
			int ans = Integer.parseInt(n);
			int src = Integer.parseInt(String.valueOf(arr));
						
			if (ans % src == 0 && ans != src) {
				answer = true;
			}
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (v[i]) continue;
			v[i] = true;
			DFS(depth + 1, n + arr[i]);
			v[i] = false;
		}
	}
	
}
