import java.util.*;

public class p3_1 {
    //정확성 46.7 %
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        List<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> c = new HashMap<String, Integer>();     

        for (int i = 0; i < genres.length; i++){
            c.put(genres[i], c.getOrDefault(genres[i], plays[i]) + plays[i]);
        }

        List<String> cl = new ArrayList<>(c.keySet());
        Collections.sort(cl, (o1, o2) -> c.get(o2).compareTo(c.get(o1)));

        for (String cate : cl){
            HashMap<Integer, Integer> s = new HashMap<Integer, Integer>();
            for (int i = 0; i < plays.length; i++){
                if (cate.equals(genres[i])) s.put(i, plays[i]);
            }            
            List<Integer> sl = new ArrayList<>(s.keySet());
            Collections.sort(sl, (o1, o2) -> s.get(o2).compareTo(s.get(o1)));

            ans.add(sl.get(0));
            if (sl.size() > 1) ans.add(sl.get(1));
        }
        answer = ans.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static int[] solution_2(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, Integer> c = new HashMap<String, Integer>();

        for (int i = 0; i < genres.length; i++){
            c.put(genres[i], c.getOrDefault(genres[i], plays[i]) + plays[i]);
        }

        List<String> cl = new ArrayList<>(c.keySet());
        Collections.sort(cl, (o1, o2) -> c.get(o2).compareTo(c.get(o1)));

        List<Integer> ans = new ArrayList<>();

        for (String gern : cl){
            List<Music> mList = new ArrayList<>();
            for (int i = 0; i < genres.length; i++){
                if (genres[i].equals(gern)) mList.add(new Music(gern, plays[i], i));
            }
            Collections.sort(mList, (o1, o2) -> o2.play - o1.play);

            for (Music m : mList) System.out.print(m.idx + " ");
            System.out.println();

            if (mList.size() == 1) 
                ans.add(mList.get(0).idx);
            else if (mList.size() > 1){
                if (mList.get(0).play == mList.get(1).play){
                    ans.add(mList.get(0).idx > mList.get(1).idx ? mList.get(1).idx : mList.get(0).idx);
                    ans.add(mList.get(0).idx > mList.get(1).idx ? mList.get(0).idx : mList.get(1).idx);
                }
                else{
                    ans.add(mList.get(0).idx);
                    ans.add(mList.get(1).idx);
                }
            }
        }

        answer = ans.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void main(String[] args) {
        String[] t1_genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] t1_plays = {500, 600, 150, 800, 2500};
        
        String[] t2_genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] t2_plays = {400, 600, 500, 500, 2500};

        //show(solution(t1_genres, t1_plays));
        //show(solution_2(t1_genres, t1_plays));
        show(solution_2(t2_genres, t2_plays));
    }

    public static void show(int[] answer){
        for (Integer ans : answer) System.out.print(ans + " ");
        System.out.println();
    }
}

class Music{
    String genre;
    int play;
    int idx;

    Music (String genre, int play, int idx){
        this.genre = genre;
        this.play = play;
        this.idx = idx;
    }
}