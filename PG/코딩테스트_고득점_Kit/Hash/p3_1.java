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

    //처음에 gen.getOrDefault(genres[i], 0) 부분에서 gen.getOrDefault(genres[i], plays[i]) +  plays[i]
    //였기 때문에 처음 연산값이 다르게 들어갔다. (key에 해당되는 객체가 없으면 0을 반환해야하는데)
    //value(plays수)를 반환했기 때문에 첫값이 x2 되어 계산 되었다.
    public static int[] solution_2(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, Integer> gen = new HashMap<String, Integer>();

        for (int i = 0; i < genres.length; i++){
            gen.put(genres[i], gen.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> genList = new ArrayList<>(gen.keySet());
        Collections.sort(genList, (o1, o2) -> gen.get(o2).compareTo(gen.get(o1)));

        List<Integer> ans = new ArrayList<>();
        
        for (String g : genList){
            List<Music> mList = new ArrayList<>();
            for (int i = 0; i < genres.length; i++){
                if (g.equals(genres[i])){
                    mList.add(new Music(g, plays[i], i));
                }
            }
            Collections.sort(mList, new Comparator<Music>(){
                @Override
                public int compare(Music m1, Music m2){
                    if (m1.play == m2.play){
                        return m1.idx - m2.idx;
                    }
                    else return m2.play - m1.play;
                }
            });

            ans.add(mList.get(0).idx);
            if (mList.size() > 1) ans.add(mList.get(1).idx);
        }

        answer = ans.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void main(String[] args) {
        String[] t1_genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] t1_plays = {500, 600, 150, 800, 2500};
        
        String[] t2_genres = {"classic", "pop", "classic", "classic", "classic"};
        int[] t2_plays = {500, 1000, 400, 300, 200};

        show(solution(t1_genres, t1_plays));
        show(solution_2(t1_genres, t1_plays));
        
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

/**
모범답안

public class Solution {
  public class Music implements Comparable<Music>{

    private int played;
    private int id;
    private String genre;

    public Music(String genre, int played, int id) {
      this.genre = genre; 
      this.played = played;
      this.id = id;
    }

    @Override
    public int compareTo(Music other) {
      if(this.played == other.played) return this.id - other.id;
      return other.played - this.played;
    }

    public String getGenre() {return genre;}
  }

  public int[] solution(String[] genres, int[] plays) {
    return IntStream.range(0, genres.length)
    .mapToObj(i -> new Music(genres[i], plays[i], i))
    .collect(Collectors.groupingBy(Music::getGenre))
    .entrySet().stream()
    .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
    .flatMap(x->x.getValue().stream().sorted().limit(2))
    .mapToInt(x->x.id).toArray();
  }

  private int sum(List<Music> value) {
    int answer = 0;
    for (Music music : value) {
      answer+=music.played;
    }
    return answer;
  }
}

 */