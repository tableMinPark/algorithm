public class p1_1{    
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        boolean[] lo = new boolean[n + 1];
        boolean[] re = new boolean[n + 2];
        
        for (int l : lost) lo[l] = true;
        for (int r : reserve) {
            if (lo[r]) lo[r] = false;
            else re[r] = true;
        }
        for (int i = 1; i < lo.length; i++) {
            if (!lo[i]) answer++;
            else{
                if (re[i - 1]) {
                    re[i - 1] = false;
                    answer++;
                }
                else if (re[i + 1]) {
                    re[i + 1] = false;
                    answer++;                    
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] t1_lost = {2, 4};
        int[] t1_reserve = {1, 3, 5};
        
        int[] t2_lost = {2, 4};
        int[] t2_reserve = {3};

        int[] t3_lost = {3};
        int[] t3_reserve = {1};

        System.out.println(solution(5, t1_lost, t1_reserve));        
        System.out.println(solution(5, t2_lost, t2_reserve));
        System.out.println(solution(3, t3_lost, t3_reserve));
    }
}