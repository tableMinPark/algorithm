import java.io.*;

public class s7732{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            String[] s = br.readLine().split(":");
            String[] e = br.readLine().split(":");

            int[] si = new int[3];
            int[] ei = new int[3];

            for (int i = 0; i < 3; i++){
                si[i] = Integer.parseInt(s[i]);
                ei[i] = Integer.parseInt(e[i]);
            }


            int ans = 0;

            while(true){
                if (si[0] == ei[0] && si[1] == ei[1] && si[2] == ei[2]) break;

                si[2] += 1;
                ans++;

                if (si[2] == 60){
                    si[1] += 1;
                    si[2] = 0;
                } 
                
                if (si[1] == 60){
                    si[0] += 1;
                    si[1] = 0;
                }

                if (si[0] == 24){
                    si[0] = 0;
                }
            }

            int se = ans % 60;
            ans /= 60;
            int mi = ans % 60;
            ans /= 60;
            int ho = ans;

            sb.append("#").append(t).append(" ").append(String.format("%02d:%02d:%02d", ho, mi, se)).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}