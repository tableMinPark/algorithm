import java.util.*;

public class p2_1 {
    //효율성 3, 4번 통과못함
    public static boolean solution(String[] phone_book) {        
        Arrays.sort(phone_book, (s1, s2) -> s1.length()-s2.length());
        List<String> p = new ArrayList<>(Arrays.asList(phone_book));
        
        for (int i = 0; i < p.size(); i++){
            int len = p.get(i).length();

            for (int j = i + 1; j < p.size(); j++){
                if (p.get(i).equals(p.get(j).substring(0, len))) return false;
            }
        }
        return true;
    }

    //문자열기준으로 정렬 후 1부터 시작하여 앞의 데이터와 뒤의 데이터를 잘라서 비교 (통과)
    public static boolean solution_2(String[] phone_book) {        
        Arrays.sort(phone_book);
        List<String> p = new ArrayList<>(Arrays.asList(phone_book));
        
        for (int i = 1; i < p.size(); i++){     
            if (p.get(i-1).length() > p.get(i).length()) continue;       
            if (p.get(i-1).equals(p.get(i).substring(0, p.get(i-1).length()))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] t1 = {"119", "97674223", "1195524421"};
        String[] t2 = {"123","456","789"};
        String[] t3 = {"12","123","1235","567","88"};
        //System.out.println(solution(t1));
        //System.out.println(solution(t2));
        //System.out.println(solution(t3));

        
        System.out.println(solution_2(t1));
        System.out.println(solution_2(t2));
        System.out.println(solution_2(t3));
    }
}
/**
모범답안

class Solution {
    public boolean solution(String[] phoneBook) {
       for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }
}

#참고사항

startsWith(String prefix)
비교 대상 문자열이 입력된 문자열 (prefix) 값으로 시작되는지 여부를 확인하고 boolean 값으로 리턴한다.

endsWith(String suffix)
비교 대상 문자열이 입력된 문자열 (suffix) 값으로 끝나는지 여부를 확인하고 boolean 값으로 리턴한다.

 */
