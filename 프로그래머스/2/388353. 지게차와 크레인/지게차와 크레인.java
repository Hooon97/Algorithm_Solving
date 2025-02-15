import java.util.*;

class Solution {
    char[][] map;
    int R,C;
    public int solution(String[] storage, String[] requests) {
        R = storage.length;
        C = storage[0].length();
        int answer = R*C;
        map = new char[R][C];
        for(int i = 0; i<R; i++) map[i] = storage[i].toCharArray();
        
        for(String request : requests){
            if(request.length() > 1) answer -= useCrane(request.charAt(0));
            else answer -= useForkLift(request.charAt(0));
        }

        return answer;
    }
    
    int[] dr = {1,-1,0,0};
    int[] dc = {0,0,1,-1};
    public int useForkLift(char target){
        int cnt = 0;
        boolean[][] visit = new boolean[R][C];
        Queue<int[]> q = new LinkedList<>();
        initStartPosition(q);
        
        while(!q.isEmpty()){
            int[] curPos = q.poll();
            int curR = curPos[0];
            int curC = curPos[1];
            if(visit[curR][curC]) continue;
            visit[curR][curC] = true;
                
            if(map[curR][curC] != '0'){
                if(map[curR][curC] == target){
                    map[curR][curC] = '0';
                    cnt++;
                }
                continue;
            }
            
            for(int i = 0; i<4; i++){
                int drs = curR + dr[i];
                int dcs = curC + dc[i];
                if(drs < 0 || drs >= R || dcs < 0 || dcs >= C) continue;
                if(!visit[drs][dcs]) q.add(new int[]{drs,dcs});
            }
        }
        
        return cnt;
    }
    
    public void initStartPosition(Queue<int[]> q){
        for(int i = 0; i<R; i++){
            q.add(new int[]{ i, 0 });
            q.add(new int[]{ i, C-1 });
        }
        for(int i = 0; i<C; i++){
            q.add(new int[]{ 0,   i });
            q.add(new int[]{ R-1, i });
        }
    }
    
    public int useCrane(char target){
        int cnt = 0;
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                if(map[i][j] == target){
                    map[i][j] = '0';
                    cnt++;
                }
            }
        }
        return cnt;
    }
}