import java.util.*;

class Solution {
    static boolean[][] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n][n];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(visit[i][j] || computers[i][j] == 0) continue;
                Dfs(i,j,computers);
                answer++;
            }
        }
        
        return answer;
    }
    public static void Dfs(int r, int c, int[][] map){
        visit[r][c] = visit[c][r] = true;
        
        for(int i = 0; i<map.length; i++){
            if(visit[c][i] || map[c][i] == 0) continue;
            Dfs(c,i, map);
        }
    }
}