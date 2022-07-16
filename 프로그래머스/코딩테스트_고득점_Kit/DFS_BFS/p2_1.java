import java.util.LinkedList;
import java.util.Queue;

public class p2_1{
    static class Number{
        int idx;
        int data;

        Number(int idx, int data){
            this.idx = idx;
            this.data = data;
        }
    }

    public static int solution(int[] numbers, int target){
        int answer = 0;

        Queue<Number> q = new LinkedList<Number>();

        q.add(new Number(0, numbers[0]));
        q.add(new Number(0, -numbers[0]));

        while (!q.isEmpty()){
            Number num = q.poll();

            if (num.idx == numbers.length - 1){
                if (num.data == target) answer++;
                continue;
            }

            q.add(new Number(num.idx + 1, num.data + numbers[num.idx + 1]));
            q.add(new Number(num.idx + 1, num.data - numbers[num.idx + 1]));
        }
        
        return answer;
    }
    public static void main(String[] args) {
        int[] t1 = {1, 1, 1, 1, 1};

        System.out.println(solution(t1, 3));
    }
}

/**
모범답안

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
}

참고한블로그 > https://www.pymoon.com/entry/Programmers-%ED%83%80%EA%B2%9F-%EB%84%98%EB%B2%84-BFSDFS-Java-%ED%92%80%EC%9D%B4
 */