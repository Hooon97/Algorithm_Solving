import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        /*
            1. L가 있는 지점까지의 최소 시간을 구한다.
            2. L에서 E까지의 최소 시간을 구한다.
            3. L까지 가지 못하거나, L에서 E까지 가는 것이 불가능하다면 -1을 반환한다.
        */
        char[][] map = new char[maps.length][maps[0].length()];
        int[][] info = new int[3][2]; // 0 : S, 1 : L, 2 : E
        for(int i = 0; i<maps.length; i++)
            map[i] = maps[i].toCharArray();
        
        
        for(int i = 0; i<map.length; i++){
            for(int j = 0; j<map[0].length; j++){
                if(map[i][j] == 'S'){
                    info[0][0] = i;
                    info[0][1] = j;
                }
                else if(map[i][j] == 'L'){
                    info[1][0] = i;
                    info[1][1] = j;
                }
                else if(map[i][j] == 'E'){
                    info[2][0] = i;
                    info[2][1] = j;
                }
            }
        }   
        
        int minL = findTime(map, info[0], info[1]);
        if(minL == -1) return -1;
        int minLE = findTime(map, info[1], info[2]);
        if(minLE == -1) return -1;
        
        return minL + minLE;
    }
    
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0 ,0, 1, -1};
    public int findTime(char[][] map, int[] st, int[] ed){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(st[0], st[1], 0));
        boolean[][] visit = new boolean[map.length][map[0].length];
        visit[st[0]][st[1]] = true;
        
        while(!q.isEmpty()){
            Point cur = q.poll();
            if(cur.r == ed[0] & cur.c == ed[1]) return cur.sec;
            for(int i = 0; i<4; i++){
                int drs = cur.r + dr[i];
                int dcs = cur.c + dc[i];
                if(drs < 0 || drs >= map.length || dcs < 0 || dcs >= map[0].length) continue;
                if(map[drs][dcs] == 'X' || visit[drs][dcs]) continue;
                q.add(new Point(drs, dcs, cur.sec+1));
                visit[drs][dcs] = true;
            }
        }
        
        return -1;
    }
    class Point{
        int r;
        int c;
        int sec;
        Point(int r, int c, int sec){
            this.r = r;
            this.c = c;
            this.sec = sec;
        }
    }
}