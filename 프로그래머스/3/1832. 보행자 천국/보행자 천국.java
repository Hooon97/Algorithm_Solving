import java.util.*;

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][] cnt = new int[m][n];
        for(int i = 0; i<n; i++){
            if(cityMap[0][i] == 1) break;
            else if(cityMap[0][i] == 2) cnt[0][i] = -1;
            else cnt[0][i] = 1;
        }
        
        for(int i = 0; i<m; i++){
            if(cityMap[i][0] == 1) break;
            else if(cityMap[i][0] == 2) cnt[i][0] = -1;
            else cnt[i][0] = 1;
        }
        
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                if(cityMap[i][j] == 1) continue;
                else if(cityMap[i][j] == 2) cnt[i][j] = -1;
                else{
                    cnt[i][j] = (findCnt(cnt, i-1, j, "R") 
                                 + findCnt(cnt, i, j-1, "D")) % MOD;
                }
            }
        }
        
        return cnt[m-1][n-1];
    }
    
    public int findCnt(int[][] cnt, int r, int c, String move){
        if(cnt[r][c] == -1){
            if(move == "R"){
                while(cnt[r][c] == -1){
                    if(--r < 0) return 0;
                }
            } else if(move == "D"){
                while(cnt[r][c] == -1){
                    if(--c < 0) return 0;
                }
            }
        }
        
        return cnt[r][c];
    }
}