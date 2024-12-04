import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        char[] answer = new char[s.length()];
        char[] sArr = s.toCharArray();
        char[] skipArr = skip.toCharArray();
        
        Set<Integer> skipCheck = new HashSet<>();
        for(int i = 0; i<skipArr.length; i++) skipCheck.add(skipArr[i] - 'a');
        
        for(int i = 0; i<sArr.length; i++){
            int curChar = sArr[i] - 'a';
            int curIdx = index;
            while(curIdx > 0){
                curChar = (curChar + 1)%('z'-'a'+1);
                if(skipCheck.contains(curChar)) continue;
                curIdx--;
            }
            answer[i] = (char) (curChar+'a');
        }
        return new String(answer);
    }
}