import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        if(k >= enemy.length) return enemy.length;
        
        PriorityQueue<Integer> card = new PriorityQueue<>(Collections.reverseOrder());
        int i;
        for(i = 0; i<enemy.length; i++){
            n -= enemy[i];
            card.add(enemy[i]);
            if(n<0){
                if(k > 0){
                    n += card.poll();   
                    k--;
                }
                else
                    break;
            }
        }
        answer = i;        
        return answer;
    }
}