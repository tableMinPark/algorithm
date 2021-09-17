import java.util.*;

public class p2_1 {
    static String[] nums;
    static boolean[] prime = new boolean[10000000];;
    static List<Integer> ans = new ArrayList<>();

    public static int solution(String numbers) {
        int answer = 0;
        for (int i = 0; i < 10000000; i++) prime[i] = true;

        prime[0] = prime[1] = false;
        for (int i = 2; i * i < 10000000; i += 1){
            for(int j = i * i; j < 10000000; j += i) {
                prime[j] = false;
            }
        }
        for (int i = 1; i <= numbers.length(); i++){
            dfs(numbers, "", i);
        }
        for (int i = 0; i < ans.size(); i++) System.out.println(ans.get(i));
        answer = ans.size();

        return answer;
    }

    public static void dfs(String numbers, String temp, int len){
        if (temp.length() == len){
            int num = Integer.parseInt(temp);
            if (prime[num] && !ans.contains(num)) ans.add(num);
            return;
        }
        else{
            for (int i = 0; i < numbers.length(); i++){
                StringBuffer sb = new StringBuffer(numbers);
                dfs(sb.deleteCharAt(i).toString(), temp + numbers.charAt(i), len);
            }
        }
    }

    public static void main(String[] args) {
        String t1 = "17";
        String t2 = "011";

        System.out.println(solution(t1));
        System.out.println(solution(t2));
    }
}

/**
모범답안

class Solution {
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while(set.iterator().hasNext()){
            int a = set.iterator().next();
            set.remove(a);
            if(a==2) count++;
            if(a%2!=0 && isPrime(a)){
                count++;
            }
        }        
        return count;
    }

    public boolean isPrime(int n){
        if(n==0 || n==1) return false;
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
            if(n%i==0) return false;
        }
        return true;
    }

    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        //if (n == 0) System.out.println(prefix);
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++){
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
        }
    }
}

#참고

HashSet울 이용해 중복을 제거했고
나의 풀이에서는 에라토스테네스의 체를 사용하여 미리 연산 후 소수를 판별하였지만
모범답안 풀이에서는 수를 맞출 때 마다 소수를 판별하는 함수를 호출했다.

참고 블로그 : https://skd03052.tistory.com/197

 */