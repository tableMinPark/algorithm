import java.io.*;
import java.util.*;

// 최솟값을 찾기 (Deque 사용)
public class BJ_11003 {
    static int N, L;
    static class Node {
        int idx;
        int value;
        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        Deque<Node> q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            // 뒤에서 부터 현재보다 큰 값을 가진 노드 다날림
            while(!q.isEmpty()) {
                if (q.getLast().value <= now) {
                    break;
                }
                q.removeLast();
            }

            // 앞에서부터 비교하면서 윈도우 범위 맞지 않는 것 다 날림
            while(!q.isEmpty()) {
                if (q.getFirst().idx >= i - L + 1) {
                    break;
                }
                q.removeFirst();
            }

            q.addLast(new Node(i, now));

            sb.append(q.getFirst().value).append(" ");
        }

        System.out.println(sb);
        br.close();
    }

}
