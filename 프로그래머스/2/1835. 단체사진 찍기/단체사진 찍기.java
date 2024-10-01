import java.util.*;

class Solution {
    int answer = 0;
    boolean[] visit;
    char[] frd = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    char[] ordrFrd;
    String[] condition;
    public int solution(int n, String[] data) {
        condition = data;
        answer = 0;
        visit = new boolean[8];
        ordrFrd = new char[8];
        // 두 친구 사이의 가능한 거리를 모두 저장하는 Map을 만들고,
        // 가능하면 answer++, 아니면 skip.

        perm(0);
        return answer;
    }
    
    public boolean ableToPass(){
        for(String cond : condition){
            int left = 0;
            int right = 0;
            int num = cond.charAt(4) - '0';
            for(int i = 0; i<8; i++){
                if(cond.charAt(0) == ordrFrd[i]) left = i;
                if(cond.charAt(2) == ordrFrd[i]) right = i;
            }
            
            int leng = Math.abs(left-right)-1;
            if(cond.charAt(3) == '='){
                if(leng != num) return false;
            } else if(cond.charAt(3) == '>'){
                if(leng <= num) return false;
            } else{
                if(leng >= num) return false;
            }
        }
        
        return true;
    }
    
    public void perm(int depth){
        if(depth == frd.length){
            if(ableToPass()) answer++;
            return;
        }
        
        for(int i = 0; i<frd.length; i++){
            if(visit[i]) continue;
            visit[i] = true;
            ordrFrd[depth] = frd[i];
            perm(depth+1);
            visit[i] = false;
            
        }
        
    }
}

/*
    ... 완탐을 하면 될까..?
    
    A, C, FN, R, J, M,  T
    NF R--T
    4*3*2*1 * 2 * 
*/


