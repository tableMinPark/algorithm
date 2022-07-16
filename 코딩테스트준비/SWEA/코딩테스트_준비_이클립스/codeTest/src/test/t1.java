package test;

import java.io.*;
import java.util.*;

public class t1 {
	static int[] arr = {1, 2, 3, 4};
	static boolean[] v;
	
	static StringBuilder sb = new StringBuilder();	
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		sb.append("모두쓰지않고, 골라서 쓸때\n");
		DFS(new StringBuilder(), 0);

		sb.append("모두 다 쓰고, 순서를 다르게\n");
		v = new boolean[4];
		DFS2(new StringBuilder(), 0);
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		br.close();
	}
	
	// 모두쓰지않고, 골라서 쓸때
	public static void DFS(StringBuilder str, int depth) {
		if (depth == 4) {
			sb.append(str.toString()).append("\n");
			return;
		}
		DFS(new StringBuilder().append(str.toString()).append(arr[depth] + " "), depth + 1);
		DFS(new StringBuilder().append(str.toString()), depth + 1);		
	}
	
	//모두 다 쓰고, 순서를 다르게
	public static void DFS2(StringBuilder str, int depth) {
		if (depth == 4) {
			sb.append(str.toString()).append("\n");
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (v[i]) continue;			
			v[i] = true;
			DFS2(new StringBuilder().append(str.toString()).append(arr[i] + " "), depth + 1);
			v[i] = false;
		}
	}
}
