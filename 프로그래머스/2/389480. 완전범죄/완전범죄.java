import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        final int MAX = 10000000;
        int answer = MAX;
        int size = info.length;
        int[][] dp = new int[size+1][m];
        for(int i = 1; i<=size; i++) Arrays.fill(dp[i], MAX);

        for(int i = 1; i<=size; i++){
            int curA = info[i-1][0];
            int curB = info[i-1][1];
            
            for(int j = 0; j<m; j++){
                
                // A가 훔칠 때
                dp[i][j] = Math.min( dp[i][j] , dp[i-1][j] + curA );
                
                if( j+curB < m){
                    dp[i][j+curB] = Math.min( dp[i][j+curB], dp[i-1][j]);
                }
            }
        }
        
        for(int i = 0; i<m; i++) answer = Math.min(answer, dp[size][i]);
        
        return answer >= n ? -1 : answer;
    }
}