import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0; i<places.length; i++){
            //map을 만든다.
            char[][] map = new char[places[0].length][places[0][0].length()];
            for(int j = 0; j<places[0].length; j++)
                map[j] = places[i][j].toCharArray();
            //P의 위치 정보 배열을 만든다.
            ArrayList<int[]> pLocation = new ArrayList<>();
            for(int p = 0; p<map.length; p++){
                for(int q = 0; q<map[0].length; q++){
                    if(map[p][q] == 'P') pLocation.add(new int[]{p,q});
                }
            }
            //두 배열을 전달하여, 맨허탄 거리를 검사한다.
            if(isMannhathan(map, pLocation)) answer[i] = 1;
            else answer[i] = 0;
        }
        
        return answer;
    }
    boolean isMannhathan(char[][] map, ArrayList<int[]> pLocation){
        boolean flag = true;
        for(int[] p : pLocation){
            if(!(upCheck(map, p) && downCheck(map, p) && 
                 rightCheck(map, p) && leftCheck(map, p) 
               && diagnalCheck(map, p))) 
                return false;
        }
        
        return flag;
    }
    boolean upCheck(char[][] map, int[] p){
        int dc = p[1];
        for(int i = 1; i<3; i++){
            int dr = p[0] - i;
            if(dr < 0) continue;
            if(map[dr][dc] == 'P') return false;
            if(map[dr][dc] == 'X') break;
        }
        return true;
    }
    
    boolean downCheck(char[][] map, int[] p){
        int dc = p[1];
        for(int i = 1; i<3; i++){
            int dr = p[0] + i;
            if(dr >= map.length) continue;
            if(map[dr][dc] == 'P') return false;
            if(map[dr][dc] == 'X') break;
        }
        return true;
    }
    
    boolean rightCheck(char[][] map, int[] p){
        int dr = p[0];
        for(int i = 1; i<3; i++){
            int dc = p[1] + i;
            if(dc >= map[0].length) continue;
            if(map[dr][dc] == 'P') return false;
            if(map[dr][dc] == 'X') break;
        }
        return true;
    }
    
    boolean leftCheck(char[][] map, int[] p){
        int dr = p[0];
        for(int i = 1; i<3; i++){
            int dc = p[1] - i;
            if(dc < 0) continue;
            if(map[dr][dc] == 'P') return false;
            if(map[dr][dc] == 'X') break;
        }
        return true;
    }
    
    boolean diagnalCheck(char[][] map, int[] p){
        int[] dr = {1, -1, 1, -1};
        int[] dc = {1, -1, -1, 1};
        for(int i = 0; i<dr.length; i++){
            int drs = p[0] + dr[i];
            int dcs = p[1] + dc[i];
            if(drs < 0 || dcs < 0 || drs >= map.length || dcs >= map[0].length) continue;
            if(map[drs][dcs] == 'P' && 
               !(map[p[0]][dcs] == 'X' && map[drs][p[1]] == 'X')) 
                return false;
        }
        return true;
    }
    
    
}