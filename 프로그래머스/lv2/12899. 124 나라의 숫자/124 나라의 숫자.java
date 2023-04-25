import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        char[] num = new char[]{'4','1','2'};
        int number = n;
        while(number > 0){
            int remain = number % 3;
            number /= 3;
            if(remain == 0) number--;
            
            sb.insert(0,num[remain]);
        }
        
        
        return sb.toString();
    }
}