package d_3;

import java.io.*;

public class s13229 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			String yo = br.readLine();
			int answer = 0;
			if (yo.equals("MON")) answer = 6;
			else if (yo.equals("TUE")) answer = 5;
			else if (yo.equals("WED")) answer = 4;
			else if (yo.equals("THU")) answer = 3;
			else if (yo.equals("FRI")) answer = 2;
			else if (yo.equals("SAT")) answer = 1;
			else answer = 7;		
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
