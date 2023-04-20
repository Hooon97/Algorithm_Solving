import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1,o2) -> {
            return o1[1] - o2[1];
        });
        
        boolean[] visit = new boolean[routes.length];
        for(int i = 0; i<routes.length; i++){
            if(visit[i]) continue;
            visit[i] = true;
            answer++;
            for(int j = i+1; j<routes.length; j++){
                if(goodToCamera(routes[i], routes[j])){
                    visit[j] = true;
                }
            }
        }
         
        return answer;
    }
    private boolean goodToCamera(int[] preRoute, int[] proRoute){
        if(preRoute[1] >= proRoute[0] && preRoute[1] <= proRoute[1])
            return true;
        return false;
    }
}