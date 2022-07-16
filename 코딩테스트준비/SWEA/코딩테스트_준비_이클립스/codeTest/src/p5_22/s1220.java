package p5_22;

import java.io.*;
import java.util.*;

public class s1220 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					arr[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			
			// N�� ����
			for (int x = 0; x < N; x++) {
				boolean downExist = false;
				for (int y = 0; y < N; y++) {
					if (arr[y][x] == 0) continue;
					
					// �������� ���� ������ true
					if (arr[y][x] == 1) downExist = true;
					
					// �������� ���� �ְ� �ö󰡴� ���� �����ϸ� �ϳ��� ���������̹Ƿ� �Ʒ��� �������� ��(�������ϼ��� ����) �� �ö󰡴� �� (�ϳ��� S)�� �ϳ��� �������·� ����
					// (F�� ��� ���� �ٸ� �������·� �Ǵ��Ͽ� 2���� �������·� ����.)
					if (arr[y][x] == 2 && downExist) {
						downExist = false;
						answer++;
					}
				}
			}
			
			// S�� ����
//			for (int x = 0; x < N; x++) {
//				boolean upExist = false;
//				for (int y = N - 1; y >= 0; y--) {
//					if (arr[y][x] == 0) continue;
//					
//					// �ö󰡴� ���� ������ true
//					if (arr[y][x] == 2) upExist = true;					
//					if (arr[y][x] == 1 && upExist) {
//						upExist = false;
//						answer++;
//					}
//				}
//			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
}

