package p5_21;

import java.io.*;

public class s13732 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			char[][] map = new char[N][N];
			
			for (int y = 0; y < N; y++) {
				map[y] = br.readLine().toCharArray();
			}
			
			int sy = 20, sx = 20;
			int ey = -1, ex = -1;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (map[y][x] == '#') {
						sy = Math.min(sy, y);
						sx = Math.min(sx, x);
						ey = Math.max(ey, y);
						ex = Math.max(ex, x);
					}
				}
			}
						
			boolean answer = true;			
			if (ey - sy != ex - sx) answer = false;
			else {
				for (int y = sy; y <= ey; y++) {
					for (int x = sx; x <= ex; x++) {
						if (map[y][x] == '.') answer = false;
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer ? "yes" : "no").append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}

// 막혀있는 칸들을 모두 사용하여 정사각형인지 판별해야함 (문제설명없음)
// 접근방식은 맞지만 코드를 잘못짬
