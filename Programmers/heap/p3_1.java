import java.util.*;


public class p3_1 {
    public static int solution(int[][] jobs){
        int answer = 0;

        LinkedList<job> w = new LinkedList<>();
        PriorityQueue<job> q = new PriorityQueue<>(new Comparator<job>() {
    		@Override
    		public int compare(job j1, job j2) {
    			return j1.time - j2.time;
    		}
    	});

        for (int[] job : jobs) w.add(new job(job[0], job[1]));

        Collections.sort(w, new Comparator<job>() {
			@Override
			public int compare(job j1, job j2) {
				return j1.start - j2.start;
			}
    	});

        int cnt = 0;
        int time = 0;

        while (cnt < jobs.length){
            while(!w.isEmpty() && w.peek().start <= time){
                q.offer(w.pollFirst());
    		}

            if (!q.isEmpty()){
                job j = q.poll();
                time += j.time;
                answer += time - j.start;
                cnt++;
            }
            else time++;
        }

        
        answer /= cnt;

        return answer;
    }

    public static void main(String[] args){
        int[][] t1 = {{0, 3}, {1, 9}, {2, 6}};

        System.out.println(solution(t1));
    }
}

class job {
    int start;
    int time;
    job(int start, int time){
        this.start = start;
        this.time = time;
    }
}

/*
모범답안

class Solution {
public static int solution(int[][] jobs) {

      Arrays.sort(jobs, new Comparator<int[]>() {
          public int compare(int[] o1, int[] o2) {
              if(o1[0] <= o2[0]){
                  return -1;
              }
              return 1;
          }
      });      

      PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
          public int compare(int[] o1, int[] o2) {
              if(o1[1] < o2[1]){
                  return -1;
              }
              return 1;
          }
      });

      int time = 0;
      int index = 0;
      float answer = 0;

      while(true){
          while(index < jobs.length && jobs[index][0] <= time){
              queue.offer(jobs[index]);
              index ++;
          }
          if(queue.size() == 0){
              time = jobs[index][0];
              continue;
          }
          int[] job = queue.poll();
          time += job[1];
          answer += time - job[0];
          if(index == jobs.length && queue.size() == 0){
              break;
          }
      }

      answer /= jobs.length;
      return (int)answer;
    }
}

#참고

요청순으로 특정 작업을 처리하는 도중 다른 요청이 들어오면
1건만 있는 경우 작업 끝나고 처리
2건 이상인 경우는 처리 시간이 짧은 항목부터 처리
해당되는 요청이 없을 시 1초씩 증가

 */