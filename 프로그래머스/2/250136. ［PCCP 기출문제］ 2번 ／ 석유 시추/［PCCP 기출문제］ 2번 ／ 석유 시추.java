import java.util.*;
/*
    1. land를 탐색하며 bfs로 석유별 개수를 기록한다.
    2. bfs 탐색이 종료될 때, 탐색하는 Column 배열에 석유의 개수를 더한다.
*/
class Solution {
    int[] colCnt;
    int ROW;
    int COL;
    public int solution(int[][] land) {
        int answer = 0;
        ROW = land.length;
        COL = land[0].length;
        colCnt = new int[COL];
        for(int i = 0; i<ROW; i++){
            for(int j = 0; j<COL; j++){
                if(land[i][j] == 1){
                    findOil(land, i, j);
                }
            }
        }
        
        for(int cnt : colCnt) answer = Math.max(answer, cnt);
        return answer;
    }
    
    public void findOil(int[][] land, int r, int c){
        int cnt = 1;
        Set<Integer> colSet = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        land[r][c] = 0;
        colSet.add(c);
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i = 0; i<4; i++){
                int drs = cur[0] + dr[i];
                int dcs = cur[1] + dc[i];
                if(drs < 0 || drs >= ROW || dcs < 0 || dcs >= COL) continue;
                if(land[drs][dcs] == 1){
                    q.offer(new int[]{drs, dcs});
                    land[drs][dcs] = 0;
                    colSet.add(dcs);
                    cnt++;
                }
            }
        }
        for(int col : colSet) colCnt[col] += cnt;
        return;
    }
}