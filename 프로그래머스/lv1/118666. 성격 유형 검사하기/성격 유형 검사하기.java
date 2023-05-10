import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        String[] options = {"RT", "CF", "JM", "AN"};
        int[] scores = new int[4];
        
        for(int i = 0; i<survey.length; i++){
            int tmp = getCharacterIndex(survey[i]);
            if(tmp != -1){
                scores[tmp] += (choices[i] - 4)*-1;
            }
            else{
                scores[getCharacterIndex(Flip(survey[i]))] += choices[i] - 4;
            }
        }
        
        for(int i = 0; i<scores.length; i++){
            if(scores[i] >= 0){
                sb.append(options[i].charAt(0));
            }
            else
                sb.append(options[i].charAt(1));
        }
        
        return sb.toString();
    }
    public int getCharacterIndex(String s){
        switch(s){
            case "RT" : return 0;
            case "CF" : return 1;
            case "JM" : return 2;
            case "AN" : return 3;
        }
        return -1;
    }
    public String Flip(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i>=0; i--) 
            sb.append(s.charAt(i));
        return sb.toString();
    }
}