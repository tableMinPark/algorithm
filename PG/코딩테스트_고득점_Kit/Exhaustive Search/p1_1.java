import java.util.*;

public class p1_1 {
    //1번 수포자 12345
    //2번 수포자 21232425
    //3번 수포자 3311224455

    public static int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] score = {0, 0, 0};

        int[][] pl = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};

        List<Queue<Integer>> person = new ArrayList<>();

        for (int[] p : pl){
            Queue<Integer> temp = new LinkedList<>();
            for (int a : p) temp.add(a);
            person.add(temp);
        }
        for (int ans : answers){
            for (int i = 0; i < 3; i++){
                if (person.get(i).peek() == ans) score[i]++;
                person.get(i).add(person.get(i).poll());
            }
        }

        List<Integer> ans = new ArrayList<>();
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        for (int i = 0; i < score.length; i++) if (max == score[i]) ans.add(i+1);

        answer = ans.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void main(String[] args) {
        int[] t1 = {1,2,3,4,5};
        int[] t2 = {1,3,2,4,2};

        show(solution(t1));
        show(solution(t2));
    }

    public static void show(int[] answer){
        for (int ans : answer) System.out.print(ans + " ");
        System.out.println();
    }
}

/**
모범답안

class Solution {
    public static int[] solution(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] hit = new int[3];
        for(int i = 0; i < hit.length; i++) {
            for(int j = 0; j < answers.length; j++) {
                if(patterns[i][j % patterns[i].length] == answers[j]) hit[i]++;
            }
        }

        int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < hit.length; i++)
            if(max == hit[i]) list.add(i + 1);

        int[] answer = new int[list.size()];
        int cnt = 0;
        for(int num : list)
            answer[cnt++] = num;
        return answer;
    }
}

#참고

patterns[i][j % patterns[i].length]

3개의 배열이 길이가 다를 때 반복하는 문제에서 유용하게 쓰일 것 같다.

 */