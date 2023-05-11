import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int maxAlp = 0;
        int maxCop = 0;
        for(int[] i : problems){
            if(maxAlp < i[0]) maxAlp = i[0];
            if(maxCop < i[1]) maxCop = i[1];
        }
        
        if(maxAlp <= alp && maxCop <= cop) return 0;
        if(maxAlp < alp) alp = maxAlp;
        if(maxCop < cop) cop = maxCop;
        
        int[][] dp = new int[maxAlp+2][maxCop+2];
        for(int i = 0; i<=maxAlp; i++){
            for(int j = 0; j<=maxCop; j++){
                dp[i][j] = 300;
            }
        }
        
        dp[alp][cop] = 0;
        for(int i = alp; i<=maxAlp; i++){
            for(int j = cop; j<=maxCop; j++){
                dp[i+1][j] = Math.min(dp[i][j]+1, dp[i+1][j]);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                
                for(int[] p : problems){
                    if(i >= p[0] && j >= p[1]){
                        int nextA = i+p[2];
                        int nextC = j+p[3];
                        if(nextA > maxAlp) nextA = maxAlp;
                        if(nextC > maxCop) nextC = maxCop;
                        dp[nextA][nextC] = Math.min(dp[nextA][nextC], dp[i][j]+p[4]);
                    }
                }
                
                
            }
        }
        return dp[maxAlp][maxCop];
    }
}
