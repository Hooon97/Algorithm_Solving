import java.util.*;

class Solution {
    public int[] solution(String str) {
        int[] answer = new int[str.length()];
        int[] location = new int[26];
        Arrays.fill(location, -1);
        
        int i = 0;
        for(char s : str.toCharArray()){
            int idx = s - 'a';
            answer[i] = location[idx] > -1 ? i-location[idx] : -1;
            location[idx] = i++;
        }
        
        return answer;
    }
}