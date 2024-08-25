import java.util.*;

class Solution {
    int[] distPerm;
    int[] extendWeak;
    boolean[] distVisit;
    int dL, wL;
    int answer;
    public int solution(int n, int[] weak, int[] dist) {
        dL = dist.length;
        wL = weak.length;
        answer = 100;
        
        extendWeak = new int[2*wL];
        for(int i = 0; i<wL; i++){
            extendWeak[i] = weak[i];
            extendWeak[i+wL] = weak[i]+n;
        }
        
        
        distPerm = new int[dL];
        distVisit = new boolean[dL];
        doPerm(dist, 0);
        
        return answer == 100 ? -1 : answer;
    }
    
    public int iterWeak(int start, int end){
        int friend = 1;
        int pos = extendWeak[start]+distPerm[friend-1];
        
        for(int i = start; i<end; i++){
            if(pos < extendWeak[i]){
                friend++;
                if(friend > dL) return 100;
                pos = extendWeak[i]+distPerm[friend-1];
            }
        }
        
        return friend;
    }
    
    public void doPerm(int[] dist, int idx){
        if(idx == dL){
            for(int i = 0; i<wL; i++)
                answer = Math.min(answer, iterWeak(i, i+wL));
            return;
        }
        
        for(int i = 0; i<dist.length; i++){
            if(distVisit[i]) continue;
            distVisit[i] = true;
            distPerm[idx] = dist[i];
            doPerm(dist, idx+1);
            distVisit[i] = false;
        }
    }
}