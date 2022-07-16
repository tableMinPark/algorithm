package p5_22_2;

import java.io.*;
import java.util.*;

public class s1873 {
	static int sy, sx, d;
	static int H, W;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[H][W];
			
			for (int y = 0; y < H; y++) {
				map[y] = br.readLine().toCharArray();
				for (int x = 0; x < W; x++) {
					if (map[y][x] != '*' && map[y][x] != '.' && map[y][x] != '#' && map[y][x] != '-') {
						sy = y;
						sx = x;
						if (map[sy][sx] == '^') d = 1;
						else if (map[sy][sx] == 'v') d = 2;
						else if (map[sy][sx] == '<') d = 3;
						else if (map[sy][sx] == '>') d = 4;
						map[sy][sx] = '.';
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();
						
			for (char com : arr) {
				if (com == 'U') {
					d = 1;
					if (isLand(map, sy -1, sx)) sy--;										
				} else if (com == 'D') {
					d = 2;
					if (isLand(map, sy + 1, sx)) sy++;					
				} else if (com == 'L') {
					d = 3;
					if (isLand(map, sy, sx - 1)) sx--;					
				} else if (com == 'R') {
					d = 4;
					if (isLand(map, sy, sx + 1)) sx++;						
				} else if (com == 'S') {
					int dy = 0, dx = 0;
					if (d == 1) dy = -1;
					else if (d == 2) dy = 1;
					else if (d == 3) dx = -1;
					else if (d == 4) dx = 1;
									
					int nextY = sy;
					int nextX = sx;
					while (true) {
						nextY += dy;
						nextX += dx;
						if (nextY < 0 || nextY >= H || nextX < 0 || nextX >= W || map[nextY][nextX] == '#') break;
						if (map[nextY][nextX] == '*') {
							map[nextY][nextX] = '.';
							break;
						}
					}
				}
			}
			
			if (d == 1) map[sy][sx] = '^';
			else if (d == 2) map[sy][sx] = 'v';
			else if (d == 3) map[sy][sx] = '<';
			else if (d == 4) map[sy][sx] = '>';
			
			sb.append("#").append(t).append(" ");
			for (int y = 0; y < H; y++) {
				for (int x = 0; x < W; x++) sb.append(map[y][x]);
				sb.append("\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static boolean isLand(char[][] map, int nextY, int nextX) {
		if (nextY < 0 || nextY >= H || nextX < 0 || nextX >= W) return false;		
		if (map[nextY][nextX] != '.') return false;
		return true;
	}
	
}
