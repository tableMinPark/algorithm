import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p1{
    public static String solution_1(String[] participant, String[] completion) {
        String answer = "";

        for (int i = 0; i < completion.length; i++){
            for (int j = 0; j < participant.length; j++){
                if (participant[j].equals(completion[i])) {
                    participant[j] = "";
                    break;
                }
            }
        }
        for (int i = 0; i < participant.length; i++){
            if (!participant[i].equals("")){
                answer = participant[i];
                break;
            }
        }
        return answer;
    }

    public static String solution_2(String[] participant, String[] completion) {
        String answer = "";

        List<String> p = new ArrayList<>(Arrays.asList(participant).stream().sorted().collect(Collectors.toList()));
        List<String> c = new ArrayList<>(Arrays.asList(completion).stream().sorted().collect(Collectors.toList()));
        int idx = p.size() - 1;

        for (int i = 0; i < c.size(); i++){
            if (!c.get(i).equals(p.get(i))){
                idx = i;
                break;
            }
        }
        answer = p.get(idx);

        return answer;
    }
    public static void main(String[] args) {
        String[] p = {"leo", "kiki", "eden"};
        String[] c = {"eden", "kiki"};
        
        System.out.println(solution_2(p, c));
    }
}

/**
모범답안

import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}

#참고사항

getOrDefault(Object key, V DefaultValue)

매개 변수 : 이 메서드는 두 개의 매개 변수를 허용합니다.

key             : 값을 가져와야 하는 요소의 키입니다.
defaultValue    : 지정된 키로 매핑된 값이 없는 경우 반환되어야 하는 기본값입니다.
반환 값         : 찾는 key가 존재하면 해당 key에 매핑되어 있는 값을 반환하고, 그렇지 않으면 디폴트 값이 반환됩니다.



 */