import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class p10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] s = br.readLine().toCharArray();
        Stack<point10799> stack = new Stack<>();

        List<stickPoint10799> stick = new ArrayList<>();
        boolean[] laser = new boolean[s.length];

        int stickCount = 0;

        for (int i = 0; i < s.length; i++){
            stack.push(new point10799(s[i], i));
            if (stack.peek().ch == ')'){
                point10799 last = stack.pop();
                point10799 start = stack.pop();
                int len = last.idx - start.idx;

                if (len == 1) laser[last.idx] = true;
                else if (len > 1) {
                    stick.add(new stickPoint10799(start.idx, last.idx));
                }
            }
        }
        for (int i = 0; i < stick.size(); i++){
            stickPoint10799 p = stick.get(i);
            int laserCount = 0;
            for (int j = p.src; j <= p.dst; j++){
                if (laser[j]) laserCount++;
            }
            stickCount += laserCount + 1;
        }
        bw.write(Integer.toString(stickCount));
        bw.flush();
        br.close();
        bw.close();
    }
}

class stickPoint10799{
    int src;
    int dst;

    stickPoint10799(int src, int dst){
        this.src = src;
        this.dst = dst;
    }
}

class point10799{
    char ch;
    int idx;

    point10799(char ch, int idx){
        this.ch = ch;
        this.idx = idx;
    }
}