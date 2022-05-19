package d_3;

import java.io.*;

public class s5549 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			char[] N = br.readLine().toCharArray();
			sb.append("#").append(t).append(" ").append((N[N.length - 1]-'0') % 2 == 0 ? "Even" : "Odd").append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
