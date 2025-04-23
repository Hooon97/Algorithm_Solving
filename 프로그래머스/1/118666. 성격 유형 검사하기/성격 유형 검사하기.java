class Solution {
    String[] personalityCategory_1;
    String[] personalityCategory_2;
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        personalityCategory_1 = new String[]{ "R", "C", "J", "A" };
        personalityCategory_2 = new String[]{ "T", "F", "M", "N" };
        int[] score = new int[4];
        
        for(int i = 0; i<survey.length; i++){
            int scr = choices[i] - 4;
            String type = "";
            if(scr < 0){
                type = String.valueOf(survey[i].charAt(0));
            } else{
                type = String.valueOf(survey[i].charAt(1));
            }
            
            int idx = getIndex(type);
            score[idx] += getScore(type, scr);
        }
           
        return createAnswer(score);
    }
    
    public String createAnswer(int[] score){
        String ans = "";
        for(int i = 0; i<score.length; i++){
            if(score[i] >= 0){
                ans += personalityCategory_1[i];
            } else{
                ans += personalityCategory_2[i];
            }
        }
        
        return ans;
    }
    
    public int getScore(String type, int score){
        for(int i = 0; i<personalityCategory_1.length; i++){
            if(personalityCategory_1[i].equals(type)){
                return Math.abs(score);
            }
        }
        
        for(int i = 0; i<personalityCategory_2.length; i++){
            if(personalityCategory_2[i].equals(type)){
                return (-1) * Math.abs(score);
            }
        }
        
        return 0;
    }
    
    public int getIndex(String type){
        for(int i = 0; i<personalityCategory_1.length; i++){
            if(personalityCategory_1[i].equals(type) || personalityCategory_2[i].equals(type)){
                System.out.println(i);
                return i;
            }
        }
        return 0;
    }
}