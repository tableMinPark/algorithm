package p5_24_2;

import java.io.*;

public class s8016 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			long K = 1;
			long K_ = 1;
			
			if (N > 1) {
				long n = N - 1;
				long a = 4;
				long d = 4;				
				K = 1 + ((a + (n - 1) * d) * n / 2);				
				
				K_ = ((a + (N - 1) * d) * N / 2) - 1;
			}
			sb.append("#").append(t).append(" ").append(K).append(" ").append(K_).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
