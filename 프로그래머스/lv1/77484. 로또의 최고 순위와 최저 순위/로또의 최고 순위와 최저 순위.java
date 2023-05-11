import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero = 0;
        int sameNumCount = 0;
        for(int i = 0; i<lottos.length; i++){
            if(lottos[i] == 0){
                zero++;
                continue;
            }
            if(containsNum(lottos[i], win_nums)){
                sameNumCount++;
            }
        }
        
        answer[0] = getRank(sameNumCount + zero);
        answer[1] = getRank(sameNumCount);

        return answer;
    }
    public boolean containsNum(int num, int[] win){
        for(int i : win)
            if(num == i) return true;
        return false;
    }
    public int getRank(int score){
        switch(score){
            case 6 : return 1;
            case 5 : return 2;
            case 4 : return 3;
            case 3 : return 4;
            case 2 : return 5;
            default : return 6;
        }
    }
}