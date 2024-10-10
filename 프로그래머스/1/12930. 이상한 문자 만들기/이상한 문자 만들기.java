import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb= new StringBuilder();
        char[] arr = s.toCharArray();
        int idx = 0;
        for(char a : arr){
            if(a == ' ') idx = -1;
            if(idx%2 == 0) a = Character.toUpperCase(a);
            else a = Character.toLowerCase(a);
            
            idx++;
            sb.append(a);
        }
        
        return sb.toString();
    }
}