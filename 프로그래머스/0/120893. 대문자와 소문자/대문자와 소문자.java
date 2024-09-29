import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        for(char a : my_string.toCharArray()){
            if(Character.isUpperCase(a)) sb.append(Character.toLowerCase(a));
            else sb.append(Character.toUpperCase(a));
        }
        
        return sb.toString();
    }
}