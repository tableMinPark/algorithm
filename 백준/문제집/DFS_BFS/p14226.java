import java.io.*;
import java.util.*;

public class p14226{
    public static class Sticker{
        int num;
        int time;
        int board;

        public Sticker(int num, int time, int board){
            this.num = num;
            this.time = time;
            this.board = board;
        }
    } 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int S = Integer.parseInt(br.readLine());

        boolean[][] v = new boolean[10001][10001];

        Queue<Sticker> q = new LinkedList<>();
        q.add(new Sticker(1, 0, 0));

        int answer = 0;

        while (!q.isEmpty()){
            Sticker s = q.poll();

            if (s.num == S){
                answer = s.time;
                break;
            }

            if (s.num > 0 && s.num <= 10000){                
                if (!v[s.num][s.num]){
                    v[s.num][s.num] = true;
                    q.add(new Sticker(s.num, s.time + 1, s.num));
                }
                if (!v[s.num - 1][s.board]){
                    v[s.num - 1][s.board] = true;
                    q.add(new Sticker(s.num - 1, s.time + 1, s.board));
                }
            }
            if (!v[s.num + s.board][s.board]){
                v[s.num + s.board][s.board] = true;
                q.add(new Sticker(s.num + s.board, s.time + 1, s.board));
            }
            
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }
}

//참고한 블로그 > https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-14226-%EC%9D%B4%EB%AA%A8%ED%8B%B0%EC%BD%98-JAVA