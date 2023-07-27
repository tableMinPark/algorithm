import java.io.*;
import java.util.*;

public class p2628 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());


        int N = Integer.parseInt(br.readLine());
        
        List<Integer>[] ans = new ArrayList[2];
        ans[0] = new ArrayList<Integer>();
        ans[1] = new ArrayList<Integer>();
        
        List<Integer>[] arr = new ArrayList[2];
        arr[0] = new ArrayList<Integer>();
        arr[1] = new ArrayList<Integer>();

        arr[0].add(0);
        arr[1].add(0);
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }
        arr[0].add(h);
        arr[1].add(w);

        Collections.sort(arr[0]);
        Collections.sort(arr[1]);

        for (int i = 1; i < arr[0].size(); i++) ans[0].add(arr[0].get(i) - arr[0].get(i - 1));
        for (int i = 1; i < arr[1].size(); i++) ans[1].add(arr[1].get(i) - arr[1].get(i - 1));
        
        Collections.sort(ans[0]);
        Collections.sort(ans[1]);

        bw.write(String.valueOf(ans[0].get(ans[0].size() - 1) * ans[1].get(ans[1].size() - 1)));
        br.close();
        bw.flush();
        bw.close();
    }
}