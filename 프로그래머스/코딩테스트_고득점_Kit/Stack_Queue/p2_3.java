import java.util.LinkedList;
import java.util.Queue;

public class p2_3{
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;

        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        for (int w : truck_weights) truck.add(w);
        for (int i = 0; i < bridge_length - 1; i++) bridge.add(0);

        
        int sum = truck.peek();
        bridge.add(truck.poll());

        while (sum != 0){
            answer++;
            sum -= bridge.poll();
            int temp = 0;

            if (truck.isEmpty()) break;
            if (sum + truck.peek() <= weight) temp = truck.poll();
            bridge.add(temp);
            sum += temp;            
        }
        answer += bridge.size();

        return answer;
    }    
    
    public static void main(String[] args) {
        int[] t1 = {7,4,5,6};
        int[] t2 = {10};
        int[] t3 = {10,10,10,10,10,10,10,10,10,10};
     
        System.out.println(solution(2, 10, t1));
        System.out.println(solution(100, 100, t2));
        System.out.println(solution(100, 100, t3));
    }
}

/**
모범답안

class Solution {
    class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (Truck t : moveQ) {
                t.moving();
            }

            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }
}

#참고

트럭을 클래스화해서 깔끔하게 잘 나타낸 답안
 */