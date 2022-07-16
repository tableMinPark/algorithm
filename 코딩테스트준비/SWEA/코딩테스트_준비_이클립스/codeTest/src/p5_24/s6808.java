package p5_24;

import java.io.*;
import java.util.*;

public class s6808 {
	static int[] gu;
	static boolean[] v;
	static int win;
	static int lose;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			gu = new int[9];
			v = new boolean[19];
			
			for (int i = 0; i < 9; i++) {
				gu[i] = Integer.parseInt(st.nextToken());
				v[gu[i]] = true;
			}
			win = 0;
			lose = 0;
			DFS(0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		
		bw.write(sb.toString());		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void DFS(int depth, int gs, int is) {
		if (depth == 9) {
			if (gs > is) win++;
			else if (gs < is) lose++;
			return;
		}
		
		for (int in = 1; in <= 18; in++) {
			if (v[in]) continue;
			v[in] = true;			
			if (in < gu[depth]) DFS(depth + 1, gs + gu[depth] + in, is);
			if (in > gu[depth]) DFS(depth + 1, gs, is + gu[depth] + in);
			v[in] = false;
		}
	}
}
