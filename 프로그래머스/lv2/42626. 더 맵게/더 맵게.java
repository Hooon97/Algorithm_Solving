import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<scoville.length; i++)
            pq.add(scoville[i]);
        
        while(!pq.isEmpty()){
            if(pq.peek() >= K || pq.size() == 1) break;
            int curScov = pq.poll() + pq.poll()*2;
            pq.add(curScov);
            answer++;
        }
        if(!pq.isEmpty() && pq.peek() < K) return -1;
        return answer;
    }
}