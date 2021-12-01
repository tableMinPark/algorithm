import java.util.*;

public class p3_3 {
    static List<String> answers;
    static boolean[] v;

    public static String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (t1, t2) -> {
            if (t1[0].equals(t2[0])){
                return t1[1].compareTo(t2[1]);
            }
            else {
                return t1[0].compareTo(t2[0]);
            }
        });

        answers = new ArrayList<>();
        v = new boolean[tickets.length + 1];

        DFS("ICN", "ICN", tickets, 0);

        Collections.sort(answers);

        return answers.get(0).split(" ");
    }
    public static void DFS(String start, String answer, String[][] tickets, int cnt){
        if (cnt == tickets.length){
            answers.add(answer);
            return;
        }

        for (int i = 0; i < tickets.length; i++){
            if (tickets[i][0].equals(start) && !v[i]){
                v[i] = true;
                DFS(tickets[i][1], answer + " " + tickets[i][1], tickets, cnt + 1);
                v[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        String[][] t1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] t2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        String[][] t3 = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};

        show(solution(t1));
        show(solution(t2));
        show(solution(t3));
    }

    public static void show(String[] value){
        for (String v : value) System.out.print(v + " ");
        System.out.println();
    }
}
