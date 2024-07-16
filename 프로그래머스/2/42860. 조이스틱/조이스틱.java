import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        /*
            1. 현재 위치에서 갱신한다.
            2. 좌, 우로 움직이며 최단 거리에 있는 위치로 이동한다.
            3. 갱신한다.
        */
        
        int idx = 0;
        int move = name.length()-1;
        boolean[] visit = new boolean[name.length()];
        for(int i = 0; i<name.length(); i++){
            answer += Math.min( name.charAt(i) - 'A', 'Z' - name.charAt(i)+1 );
            
            idx = i+1;
            while(idx < name.length() && name.charAt(idx) == 'A'){
                idx++;
            }
            
            move = Math.min(move, i*2+name.length()-idx);
            move = Math.min(move, (name.length()-idx)*2+i);   
        }
        // JANAAN
        answer += move;
        
        return answer;
    }
}