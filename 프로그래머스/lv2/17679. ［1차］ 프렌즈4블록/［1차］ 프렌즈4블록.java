import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[board.length][board[0].length()];
        for(int i = 0; i<board.length; i++){
            map[i] = board[i].toCharArray();
        }
        
        ArrayList<int[]> A = new ArrayList<>();
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 0; i<m-1; i++){
                for(int j = 0; j<n-1; j++){
                    if(ableDelete(map, i, j)){ //지워지는 부분이 있으면
                        flag = true;
                        A.add(new int[]{i,j});
                    }
                }
            }
            answer += mapDelete(map, A);
            mapSort(map);
        }
        
        return answer;
    }
    
    public boolean ableDelete(char[][] map, int i, int j){
        int[] dr = {0,0,1,1};
        int[] dc = {0,1,0,1};
        char firstCharacter = map[i][j];
        for(int t = 0; t<dr.length; t++){
            int drs = i + dr[t];
            int dcs = j + dc[t];
            if(drs < 0 || drs >= map.length || dcs < 0 || dcs >= map[0].length){
                return false;
            }
            if(firstCharacter == ' ' || map[drs][dcs] != firstCharacter) 
                return false;
        }
        return true;
    }
    
    public int mapDelete(char[][] map, ArrayList<int[]> A){
        int[] dr = {0,0,1,1};
        int[] dc = {0,1,0,1};
        int count = 0;
        for(int[] coord : A){
            for(int i = 0; i<dr.length; i++){
                int curR = coord[0] + dr[i];
                int curC = coord[1] + dc[i];
                if(map[curR][curC] != ' '){
                    count++;
                    map[curR][curC] = ' ';
                }
            }
        }
        A.clear();
        return count;
    }
    
    public void mapSort(char[][] map){
        for(int i = 0; i<map[0].length; i++){
            int idx = map.length-1;
            int blankCount = 0;
            while(idx >= 0){
                if(map[idx][i] == ' '){
                    blankCount++;
                }
                else if(blankCount != 0){
                    map[idx+blankCount][i] = map[idx][i];
                    map[idx][i] = ' ';
                }
                idx--;
            }
        }
    }
}