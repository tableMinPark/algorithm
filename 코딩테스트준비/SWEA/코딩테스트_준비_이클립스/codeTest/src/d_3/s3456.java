package d_3;

import java.io.*;
import java.util.*;

public class s3456 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
				
		for (int t = 1; t <= T; t++) {
			int[] arr = new int[101];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) arr[Integer.parseInt(st.nextToken())]++;
			
			sb.append("#").append(t).append(" ");
			for (int i = 1; i <= 100; i++) {
				if (arr[i] == 0) continue;
				if (arr[i] % 2 == 1) {
					sb.append(i).append("\n");
					break;
				}
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
