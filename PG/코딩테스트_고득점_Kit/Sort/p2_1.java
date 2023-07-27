import java.util.*;

public class p2_1 {
    public static String solution(int[] numbers) {
        String answer = "";

        String[] num = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) num[i] = Integer.toString(numbers[i]);

        Arrays.sort(num, new Comparator<String>(){
            @Override
            public int compare(String n1, String n2){
                return (n2 + n1).compareTo(n1 + n2);}
                //return (n1 + n2).compareTo(n2 + n1);}
                //내림차순
        });
        
        for (String n : num) answer += n;

        if (answer.charAt(0) == '0') answer = "0";

        return answer;
    }

    public static void main(String[] args) {
        int[] t1 = {6, 10, 2};
        int[] t2 = {3, 30, 34, 5, 9};
        int[] t3 = {10, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] t4 = {0, 0, 0, 0};

        System.out.println(solution(t1));
        System.out.println(solution(t2));
        System.out.println(solution(t3));
        System.out.println(solution(t4));
    }
} 

/**
모범답안

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }
        answer = sb.toString();
        if(answer.charAt(0) == '0') {
            return "0";
        }else {
            return answer;
        }
    }
}

#참고

a.compareTo(b)
- 앞에서부터 비교하다 다른 문자열이 나오면 'a-b' 순서로 
  해당 문자의 아스키코드 값을 뺀 결과(int)를 리턴

내림차순 : (n2+n1).compareTo(n1+n2);
오름차순 : (n1+n2).compareTo(n2+n1);

https://ivory-room.tistory.com/43
 */