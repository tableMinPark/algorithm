import java.util.*;

public class p3_2{
    public static class Word{
        int idx;
        String word;

        public Word(int idx, String word){
            this.idx = idx;
            this.word = word;
        }
    }
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;

        boolean[] v = new boolean[words.length];

        Queue<Word> q = new LinkedList<>();
        q.add(new Word(0, begin));

        while (!q.isEmpty()){
            Word w = q.poll();

            if (w.word.equals(target)) {
                answer = w.idx;
                break;
            }

            for (int i = 0; i < words.length; i++){
                if (v[i]) continue;
                int count = 0;
                for (int j = 0; j < target.length(); j++) if (words[i].charAt(j) == w.word.charAt(j)) count++;
                if (count == target.length() - 1){
                    v[i] = true;
                    q.add(new Word(w.idx + 1, words[i]));
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] t1 = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] t2 = {"hot", "dot", "dog", "lot", "log"};
        String[] t3 = {"cog", "log", "lot", "dog", "dot", "hot"};

        System.out.println(solution("hit", "cog", t1));
        System.out.println(solution("hit", "cog", t2));
        System.out.println(solution("hit", "cog", t3));
    }
}