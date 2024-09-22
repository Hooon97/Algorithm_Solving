import java.util.*;

class Solution {
    /*
        1. 가능한 점수 : 1 ~ 20 (Single) / (1~20) * 2 / (1~20) * 3
                        50 (Bool)
        2. 동점 우선순위 : Single+Bool 개수 / 선공
        3. 승부 우선순위 : 다트 개수 / 동점 우선순위
    */
    public int[] solution(int target) {
        if(target <= 20) return new int[]{1,1};
        int MAX = 100001;
        
        int[][] dp = new int[target+1][2];
        for(int i = 1; i<=target; i++){
            dp[i][0] = MAX;
            dp[i][1] = MAX;
        }
        
        for(int i = 1; i<=20; i++){
            dp[i] = new int[]{1, 1};
            if(target >= i*2) dp[i*2] = new int[]{1,0};
            if(target >= i*3) dp[i*3] = new int[]{1, 0};
            if(target >= i*50) dp[i*50] = new int[]{i*50, i};
        }
        
        for(int i = 1; i<=target; i++){
            for(int j = 0; j<=20; j++){
                if(i - j >= 0) dp[i] = getMinCount(dp[i], dp[i-j], 1, 1);
                if(i - j * 2 >= 0) dp[i] = getMinCount(dp[i], dp[i-j*2], 1, 0);
                if(i - j * 3 >= 0) dp[i] = getMinCount(dp[i], dp[i-j*3], 1, 0);
                if(i - j*50 >= 0) dp[i] = getMinCount(dp[i], dp[i-j*50], j, j);
            }
        }
        return dp[target];
    }
    
    private int[] getMinCount(int[] cur, int[] pre, int count, int single){
        int[] result = new int[]{cur[0], cur[1]};
        
        if(cur[0] == pre[0]+count){
            if(cur[1] < pre[1]+single){
                result[0] = pre[0]+count;
                result[1] = pre[1]+single;
            }
        } else if(cur[0] > pre[0]+count){
            result[0] = pre[0]+count;
            result[1] = pre[1]+single;
        }
        
        return result;
    }
}