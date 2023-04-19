import java.util.*;

class Solution {
    final static int PUDDLE = -1;
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] road = new int[n+1][m+1];
        for(int i = 0; i<puddles.length; i++){
            road[puddles[i][1]][puddles[i][0]] = PUDDLE;
        }

        // 초기값 설정
        for(int i = 1; i<m+1; i++){
            if(road[1][i] == PUDDLE) break;
            road[1][i] = 1;
        }
        for(int i = 1; i<n+1; i++){
            if(road[i][1] == PUDDLE) break;
            road[i][1] = 1;
        }
        
        for(int i = 2; i<n+1; i++){
            for(int j = 2; j<m+1; j++){
                if(road[i][j] != PUDDLE){
                    if(road[i][j] > 1000000007) road[i][j] %= 1000000007;
                    if(road[i-1][j] == PUDDLE && road[i][j-1] == PUDDLE)
                        road[i][j] = 0;
                    else if(road[i-1][j] == PUDDLE && road[i][j-1] != PUDDLE)
                        road[i][j] = road[i][j-1]%1000000007;
                    else if(road[i-1][j] != PUDDLE && road[i][j-1] == PUDDLE)
                        road[i][j] = road[i-1][j]%1000000007;
                    else if(road[i-1][j] != PUDDLE && road[i][j-1] != PUDDLE)
                        road[i][j] = (road[i-1][j] + road[i][j-1]) % 1000000007;
                }
            }
        }
        
        return road[n][m];
    }
}