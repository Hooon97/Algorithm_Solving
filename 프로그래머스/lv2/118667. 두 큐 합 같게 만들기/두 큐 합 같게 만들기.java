import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i : queue1){
            sum1 += i;
            q1.offer(i);
        }
            
        for(int i : queue2){
            sum2 += i;
            q2.offer(i);
        }
        long len =  (queue1.length + queue2.length)*2;
        while(sum1 != sum2){
            if(q1.isEmpty() || q2.isEmpty() || answer > len){
                answer = -1;
                break;
            }
            if(sum1 > sum2){
                int cur1 = q1.poll();
                sum1 -= cur1;
                sum2 += cur1;
                q2.offer(cur1);
            }
            else{
                int cur2 = q2.poll();
                sum1 += cur2;
                sum2 -= cur2;
                q1.offer(cur2);
            }
            answer++;
        }
        
        return answer;
    }
}