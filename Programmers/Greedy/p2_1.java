public class p2_1 {
    public static int solution(String name) {
        int answer = 0;

        char[] cn = name.toCharArray();
        int min = cn.length - 1;
        
        for (int i = 0; i < cn.length; i++){
            answer += Math.min(cn[i] - 'A', 'Z' - cn[i] + 1);

            int next = i + 1;
            while (next < cn.length && cn[next] == 'A') next++;
            
            min = Math.min(min, (2 * i) + cn.length - next);
        }

        answer += min;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
        System.out.println(solution("JAN"));
        System.out.println(solution("JAZ"));
    }
}
