import java.util.*;

class Solution {
    public int solution(int or_num) {
        int answer = 0;
        Set<Long> numCheck = new HashSet<>();
        long num = or_num;
        while(!numCheck.contains(num)){
            if(num == 1) return answer;
            if(answer >= 500) return -1;
            answer++;
            numCheck.add(num);
            
            if(num % 2 == 0) num /= 2;
            else{
                num *= 3;
                num ++;
            }
        }
        
        return -1;
    }
}