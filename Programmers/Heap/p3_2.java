import java.util.*;

public class p3_2 {
    public static int[] solution(String[] operations) {
        int[] answer = {};

        PriorityQueue<Integer> uq = new PriorityQueue<>();
        PriorityQueue<Integer> dq = new PriorityQueue<>(Collections.reverseOrder());


        for (String op : operations){
            StringTokenizer st = new StringTokenizer(op);

            String oper = st.nextToken();

            if (oper.equals("I")){
                int temp = Integer.parseInt(st.nextToken());
                uq.add(temp);
                dq.add(temp);
            }
            else if (uq.isEmpty() && dq.isEmpty()) continue;
            else if (oper.equals("D")){
                if (Integer.parseInt(st.nextToken()) < 0){
                    int t = uq.poll();
                    dq.remove(t);
                }
                else{
                    int t = dq.poll();
                    uq.remove(t);
                }
            }
            
        }
        List<Integer> ans = new ArrayList<>();

        if (uq.isEmpty() && dq.isEmpty()){
            ans.add(0);
            ans.add(0);
        }
        else{
            ans.add(dq.poll());
            ans.add(uq.poll());
        }

        answer = ans.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void main(String[] args){
        String[] t1 = {"I 16","D 1"};
        String[] t2 = {"I 7","I 5","I -5","D -1"};

        show(solution(t1));
        show(solution(t2));
    }

    public static void show(int[] answer){
        for (int ans : answer) System.out.print(ans + " ");
        System.out.println();
    }
}