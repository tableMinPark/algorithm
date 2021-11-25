public class p2_2 {
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int idx = 0;
        int max = 0;
        for (int i = 0; i < number.length() - k; i++){
            max = 0;
            for (int j = idx; j <= i + k; j++){
                if (max < number.charAt(j)-'0'){
                    max = number.charAt(j)-'0';
                    idx = j + 1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }
}

/**
모범답안

import java.util.Stack;
class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
 */