import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
    
        int deliverIdx = n-1;
        int pickupsIdx = n-1;
        
        while(deliverIdx >= 0 || pickupsIdx >= 0){
            deliverIdx = findNextIdx(deliveries, deliverIdx);
            pickupsIdx = findNextIdx(pickups, pickupsIdx);
            
            int start = Math.max(deliverIdx, pickupsIdx);
            answer += (start+1)*2;
            int delCap = cap;
            int picCap = cap;
            
            int tmpDelIdx = deliverIdx;
            while(delCap > 0 && tmpDelIdx >= 0){
                if(deliveries[tmpDelIdx] > 0){
                    if(deliveries[tmpDelIdx] <= delCap){
                        delCap -= deliveries[tmpDelIdx];
                        deliveries[tmpDelIdx] = 0;
                    } else{
                        deliveries[tmpDelIdx] -= delCap;
                        delCap = 0;
                    }
                } else{
                    tmpDelIdx--;
                }
                
                deliverIdx = tmpDelIdx;
            }
            
            int tmpPicIdx = pickupsIdx;
            while(picCap > 0 && tmpPicIdx >= 0){
                if(pickups[tmpPicIdx] > 0){
                    if(pickups[tmpPicIdx] <= picCap){
                        picCap -= pickups[tmpPicIdx];
                        pickups[tmpPicIdx] = 0;
                    } else{
                        pickups[tmpPicIdx] -= picCap;
                        picCap = 0;
                    }
                } else{
                    tmpPicIdx--;
                }
                
                pickupsIdx = tmpPicIdx;
            }
        }
        
        
        
        return answer;
    }
    
    public int findNextIdx(int[] arr, int idx){
        for(int i = idx; i>=0; i--){
            if(arr[i] > 0) return i;
        }
        
        return -1;
    }
}