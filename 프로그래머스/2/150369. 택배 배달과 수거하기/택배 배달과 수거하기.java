import java.util.*;

class Solution {
    public long solution(int capacity, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        /*
            1. delivery만 생각한다면, 뒤에서부터 최대 용달로 배달하면된다.
            2. 트럭이 가야하는 최장 거리를 가면, 다시 원점으로 복귀해야 한다.
            3. 가장 먼 delivery를 먼저 배달하고, 해당 지점까지 배달이 되면 수거를 탐색한다.
            4. 배달과 수거 배열은 투포인터로 탐색한다.
        */
        
        int dIdx = deliveries.length-1;
        int pIdx = pickups.length-1;
        
        int cap = capacity;
        while(dIdx >= 0 || pIdx >= 0){
            dIdx = findNotZero(deliveries, dIdx);
            pIdx = findNotZero(pickups, pIdx);
            answer += (Math.max(dIdx, pIdx)+1)*2;
            
            cap = capacity;
            while(dIdx >= 0 && cap > 0){
                if(deliveries[dIdx] <= cap){
                    cap -= deliveries[dIdx];
                    deliveries[dIdx] = 0;
                    dIdx = findNotZero(deliveries, dIdx);
                } else{
                    deliveries[dIdx] -= cap;
                    cap = 0;
                }
            }
            
            cap = capacity;
            while(pIdx >= 0 && cap > 0){
                if(pickups[pIdx] <= cap){
                    cap -= pickups[pIdx];
                    pickups[pIdx] = 0;
                    pIdx = findNotZero(pickups, pIdx);
                } else {
                    pickups[pIdx] -= cap;
                    cap = 0;
                }
            }
        }
        return answer;
    }
    
    public int findNotZero(int[] arr, int start){
        for(; start >= 0; start--){
            if(arr[start] > 0) return start;
        }
        
        return -1;
    }
}