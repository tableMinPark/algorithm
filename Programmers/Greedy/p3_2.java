import java.util.Arrays;

public class p3_2 {
    public static int solution(int[][] routes){
        int answer = 0;

        Arrays.sort(routes, (r1, r2) -> {
            return r1[1] - r2[1];
        });

        int min = Integer.MIN_VALUE;

        for (int[] route : routes){
            if (min < route[0]){
                min = route[1];
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int[][] t1 = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        int[][] t2 = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};

        System.out.println(solution(t1));
        System.out.println(solution(t2));
    }
}

//참고한 블로그 >> https://velog.io/@ahnick/programmers-%EB%8B%A8%EC%86%8D%EC%B9%B4%EB%A9%94%EB%9D%BC