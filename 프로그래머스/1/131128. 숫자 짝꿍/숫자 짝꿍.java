import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        Map<String, Long> xMap = new HashMap<>();
        Map<String, Long> yMap = new HashMap<>();
        
        for(char x : X.toCharArray()) xMap.put(String.valueOf(x), xMap.getOrDefault(String.valueOf(x), (long)0)+1);
        for(char y : Y.toCharArray()) yMap.put(String.valueOf(y), yMap.getOrDefault(String.valueOf(y), (long)0)+1);
        
        for(int i = 9; i>=0; i--){
            if(xMap.containsKey(String.valueOf(i)) && yMap.containsKey(String.valueOf(i))){
                long cnt = Math.min(xMap.get(String.valueOf(i)), yMap.get(String.valueOf(i)));
                for(long j = 0; j<cnt; j++) sb.append(String.valueOf(i));
            }
        }
        
        if(sb.toString().equals("")) return "-1";
        else if(sb.toString().charAt(0) == '0') return "0";
        else return sb.toString();
    }
}