import java.util.*;

class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }
    public int bfs(int[][] maps){
        int n = maps.length-1;
        int m = maps[0].length-1;
        
        boolean[][] visit = new boolean[n+1][m+1];
        Queue<Location> q = new LinkedList<>();
        q.add(new Location(0,0,1));
        
        while(!q.isEmpty()){
            Location cur = q.poll();
            if(cur.r == n && cur.c == m){
                return cur.count;
            }
            for(int i = 0; i<4; i++){
                int drs = cur.r + dr[i];
                int dcs = cur.c + dc[i];
                if(drs < 0 || drs > n || dcs < 0 || dcs > m) continue;
                if(visit[drs][dcs] || maps[drs][dcs] == 0) continue;
                visit[drs][dcs] = true;
                q.add(new Location(drs,dcs,cur.count+1));
            }
            
        }
        return -1;
    }
}
class Location{
    int r;
    int c;
    int count;
    Location(int r, int c, int count){
        this.r = r;
        this.c = c;
        this.count = count;
    }
}