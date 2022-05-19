package d_3;

import java.io.*;
import java.util.*;

public class s5431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	
        	boolean[] v = new boolean[N];
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < K; i++) {
        		v[Integer.parseInt(st.nextToken()) - 1] = true;
        	}
        	
        	sb.append("#").append(t);
        	for (int i = 0; i < N; i++) {
        		if (!v[i]) sb.append(" ").append(i + 1);
        	}
        	sb.append("\n");
        }
        
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}