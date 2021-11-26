import java.util.*;

public class p2_3 {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Integer[] peo = Arrays.stream(people).boxed().toArray(Integer[]::new); 
        Arrays.sort(peo, Comparator.reverseOrder());
        
        int l = 0;
        int r = peo.length - 1;
        
        while (l < r){
            int sum = peo[l] + peo[r];
            if (sum > limit) l++;
            else{
                l++;
                r--;
            }
            answer++;
        }
        if (l == r) answer++;

        return answer;
    }

    public static void main(String[] args) {
        int[] t1_people = {70, 50, 80, 50};
        int[] t2_people = {70, 80, 50};

        System.out.println(solution(t1_people, 100));
        System.out.println(solution(t2_people, 100));
    }
}
