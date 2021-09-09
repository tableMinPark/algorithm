import java.util.Arrays;
import java.util.HashMap;

public class p2_2 {
    public static int solution(String[][] clothes) {
        int answer = 1;

        Arrays.sort(clothes, (s1, s2) -> s1[1].compareTo(s2[1]));
        HashMap<String, Integer> c = new HashMap<>();

        for (String[] cloth : clothes){
            c.put(cloth[1], c.getOrDefault(cloth[1], 0) + 1);
        }
        for (String k : c.keySet()){
            answer *= c.get(k) + 1;
        }
        answer -= 1;

        return answer;
    }

    public static void main(String[] args) {
        String[][] t1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] t2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(solution(t1));
        System.out.println(solution(t2));
    }
}

/**
 모범답안
 
 class Solution {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }
}
 */