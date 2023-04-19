import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : works)
            pq.add(i);
        while(n --> 0){
            if(pq.size() == 0) break;
            int cur = pq.poll()-1;
            if(cur < 1) continue;
            pq.add(cur);
        }
        if(pq.size() == 0) return 0;
        else{
            while(!pq.isEmpty()){
                answer += Math.pow(pq.poll(),2);
            }
        }
        
        return answer;
    }
}