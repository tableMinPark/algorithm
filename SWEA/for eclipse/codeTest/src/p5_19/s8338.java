package p5_19;

import java.io.*;
import java.util.*;

/*
 * 수식을 계산할 때 연산자의 우선 순위는 고려하지 않고 왼쪽에서 오른쪽으로 차례대로 계산한다.
 계산기에 계산된 결과로 나올 수 있는 값 중 최대값을 구하여 방 탈출에 성공하자.
*/

public class s8338 {	
	static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= T; t++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	int[] arr = new int[N];
        	
        	st = new StringTokenizer(br.readLine());        	
        	for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());       	
        	
        	answer = 0;
        	DFS(arr, N, 0, 0);
        	
        	sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        
        bw.write(sb.toString());        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void DFS(int[] arr, int N, int d, int s) {
    	if (d == N) {
    		answer = Math.max(answer, s);
    		return;
    	}
    	DFS(arr, N, d + 1, s + arr[d]);
    	DFS(arr, N, d + 1, s * arr[d]);
    }
}