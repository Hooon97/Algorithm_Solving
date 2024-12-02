import java.util.*;

class Solution {
    String[] words;
    String lastWord;
    public int solution(String[] babbling) {
        int answer = 0;
        words = new String[]{ "aya", "ye", "woo", "ma" };
        for(String babble : babbling){
            lastWord = "";
            if(speakable(babble)) answer++;
        }
        
        return answer;
    }
    public boolean speakable(String str){
        if(str.equals("")) return true;
        for(int i = 0; i<4; i++){
            if(str.startsWith(words[i])){
                if(lastWord.equals(words[i])) return false;
                lastWord = words[i];
                return speakable(str.substring(words[i].length()));
            }
        }
        
        return false;
    }
}