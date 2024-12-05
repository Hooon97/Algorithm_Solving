import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> minTouchMap = new HashMap<>();
        for(String key : keymap){
            char[] keyEleArr = key.toCharArray();
            for(int i = 0; i< keyEleArr.length; i++){
                minTouchMap.put( keyEleArr[i], Math.min(i+1, minTouchMap.getOrDefault(keyEleArr[i], 1001)) );
            }
        }
        for(int i = 0; i<targets.length; i++){
            int sum = 0;
            for(char ele : targets[i].toCharArray()){
                if(!minTouchMap.containsKey(ele)){
                    answer[i] = -1;
                    break;
                } else{
                    sum += minTouchMap.get(ele);
                }
            }
            if(answer[i] != -1) answer[i] = sum;
        }
        
        return answer;
    }
}