package p5_19;

import java.io.*;
import java.util.*;

/*
 * �� ���� ���� X�� Y�� �ִ�. ����� 0�ʿ������� �����Ͽ� 100�ʰ� �� ������ ���� ���������� �����Ͽ���.
  ���� ���, ���� X�� ���� ���� ��� �� A�ʿ������� ���� ���� ��� �� B�ʱ������� ���� �־���. ���� Y�� ���� ���� ��� �� C�ʿ������� ���� ���� ��� �� D�ʱ������� ���� �־���.
  ����� �� ������ �����ϴ� 100�� �� �� ������ ���ÿ� ���� �ִ� �ð��� �� ���ϱ�?  
*/

public class s12741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	int C = Integer.parseInt(st.nextToken());
        	int D = Integer.parseInt(st.nextToken());
        	
        	boolean[] x = new boolean[101];
        	boolean[] y = new boolean[101];
        	
        	
        	int answer = 0;
        	for (int i = A; i < B; i++) x[i] = true;
        	for (int i = C; i < D; i++) y[i] = true;
        	for (int i = 0; i <= 100; i++) {
        		if (x[i] && y[i]) answer++;
        	}
        	sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        
        bw.write(sb.toString());        
        br.close();
        bw.flush();
        bw.close();
    }
}