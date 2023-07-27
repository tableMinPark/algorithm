package d_3;

import java.io.*;
import java.util.*;

public class s1229 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			List<Integer> arr = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) arr.add(Integer.parseInt(st.nextToken()));
			
			int C = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < C; i++) {
				char com = st.nextToken().charAt(0);
				
				if (com == 'I') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j = x; j < x + y; j++) arr.add(j, Integer.parseInt(st.nextToken()));
										
				} else if (com == 'D') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());					
					for (int j = 0; j < y; j++) arr.remove(x);
				}
			}
			
			sb.append("#").append(t);
			for (int i = 0; i < 10; i++) sb.append(" ").append(arr.get(i));
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
}
