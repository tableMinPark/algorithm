package d_3;

import java.io.*;
import java.util.*;

public class s8500 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int sum = 0;
			int past = 0;
			
			Arrays.sort(arr);
			
			for (int i = 0; i < N; i++) {
				if (past > arr[i]) {
					sum += past;
				} else {
					sum += arr[i];
				}
				past = arr[i];
			}
			sum += N + arr[N - 1];
			
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
