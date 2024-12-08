import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        for(int i = sArr.length-1; i>=0; i--) sb.append(sArr[i]);
        
        return sb.toString();
    }
}