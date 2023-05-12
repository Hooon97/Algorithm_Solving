import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] dist = new int[N+1];
        int[] sumDist = new int[N+2];
        PriorityQueue<Rate> pq = new PriorityQueue<>();
        
        for(int i : stages) dist[i-1]++;
        for(int i = N; i>=0; i--){
            sumDist[i] = sumDist[i+1] + dist[i];
        }
       
        for(int i = 1; i<N+1; i++){
            if(sumDist[i-1] == 0) pq.add(new Rate(0, i));
            else pq.add(new Rate(((float)(sumDist[i-1]-sumDist[i])/sumDist[i-1]), i));
        }
        int idx = 0;
        while(!pq.isEmpty()){
            Rate c = pq.poll();
            answer[idx++] = c.stage;
        }

        return answer;
    }
}
class Rate implements Comparable<Rate>{
    float rate;
    int stage;
    Rate(float rate, int stage){
        this.rate = rate;
        this.stage = stage;
    }
    
    public int compareTo(Rate r){
        if(rate == r.rate){
            return stage-r.stage;
        }
        else if(rate >= r.rate){
            return -1;
        }
        else return 1;
    }
}