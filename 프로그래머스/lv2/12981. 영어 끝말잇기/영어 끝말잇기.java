import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        HashSet<String> usedWord = new HashSet<>();
        usedWord.add(words[0]);
        for(int i = 1; i<words.length; i++){
            if(usedWord.contains(words[i]) || !isCorrect(words[i-1], words[i])){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                System.out.println(i);
                break;
            }
            else{
                usedWord.add(words[i]);
            }
        }

        return answer;
    }
    private boolean isCorrect(String before, String after){
        if(before.charAt(before.length()-1) == 
           after.charAt(0))
        {
            return true;
        }
        else return false;
    }
}