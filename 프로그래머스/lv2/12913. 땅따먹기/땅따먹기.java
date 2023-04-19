import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[][] dis = new int[land.length][4];
        dis[0] = land[0];
        
        for(int i = 1; i<land.length; i++){
            dis[i][0] = Math.max(Math.max(dis[i-1][1], dis[i-1][2]), dis[i-1][3])+land[i][0];
            dis[i][1] = Math.max(Math.max(dis[i-1][0], dis[i-1][2]), dis[i-1][3])+land[i][1];
            dis[i][2] = Math.max(Math.max(dis[i-1][1], dis[i-1][0]), dis[i-1][3])+land[i][2];
            dis[i][3] = Math.max(Math.max(dis[i-1][1], dis[i-1][2]), dis[i-1][0])+land[i][3];
        }
        
        int answer = 0;
        for(int i = 0; i<4; i++)
            answer = Math.max(answer, dis[land.length-1][i]);
        
        return answer;
    }
}