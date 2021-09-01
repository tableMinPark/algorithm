import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        MyDeque q = new MyDeque();

        int c = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_front":
                    q.push_front(Integer.parseInt(st.nextToken()));                    
                    break;
                case "push_back":
                    q.push_back(Integer.parseInt(st.nextToken()));                          
                    break;
                case "pop_front":
                    sb.append(q.pop_front()).append("\n");
                    break;
                case "pop_back":
                    sb.append(q.pop_back()).append("\n");                    
                    break;
                case "size":                    
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.empty()).append("\n");                    
                    break;
                case "front":
                    sb.append(q.front()).append("\n");
                    break;
                case "back":
                    sb.append(q.back()).append("\n");
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
class MyDeque{
    LinkedList<Integer> de;

    MyDeque(){
        this.de = new LinkedList<>();
    }
    public void push_front(int X){
        de.addFirst(X);
    }

    public void push_back(int X){
        de.add(X);
    }

    public int pop_front(){
        int r = -1;
        if (!de.isEmpty()) r = de.pollFirst();
        return r;
    }
    
    public int pop_back(){
        int r = -1;
        if (!de.isEmpty()) r = de.pollLast();
        return r;
    }
    
    public int size(){
        return de.size();
    }

    public int empty(){
        return de.isEmpty() ? 1 : 0;
    }

    public int front(){        
        int r = -1;
        if (!de.isEmpty()) r = de.peekFirst();
        return r;
    }

    public int back(){        
        int r = -1;
        if (!de.isEmpty()) r = de.peekLast();
        return r;
    }
}