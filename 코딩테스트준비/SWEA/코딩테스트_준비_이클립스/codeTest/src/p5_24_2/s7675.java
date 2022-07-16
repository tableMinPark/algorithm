package p5_24_2;

import java.io.*;
import java.util.*;

public class s7675 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			String[] str = br.readLine().split("\\.|\\?|!");
					
			sb.append("#").append(t);
			for (int j = 0; j < N; j++) {				
				String[] cent = str[j].trim().split(" ");
				
				int cnt = 0;
				for (String w : cent) {	
					char[] arr = w.toCharArray();
					
					if (arr[0] >= 'A' && arr[0] <= 'Z'){
                        boolean check = true;
                        for (int i = 1; i < arr.length; i++) {
                            if (arr[i] < 'a' || arr[i] > 'z') {
                                check = false;
                                break;
                            }
                        }
                        if (check) cnt++;
                    }
				}
				sb.append(" ").append(cnt);
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
}
