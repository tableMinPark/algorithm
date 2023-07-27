package d_3;

import java.io.*;
import java.util.*;

public class s10804 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			Stack<Character> stack = new Stack<>();
			
			for (char ch : br.readLine().toCharArray()) stack.add(ch);
			
			sb.append("#").append(t).append(" ");
			while(!stack.isEmpty()) {
				char ch = stack.pop();				
				if (ch == 'q') sb.append('p');
				else if (ch == 'p') sb.append('q');
				else if (ch == 'd') sb.append('b');
				else if (ch == 'b') sb.append('d');
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
