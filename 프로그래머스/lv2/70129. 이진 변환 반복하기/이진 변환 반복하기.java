class Solution {
    static int countZero, countTrans;
    public int[] solution(String s) {
        countZero = 0;
        countTrans = 0;
        
        Transform(s);
        
        int[] answer = {countTrans, countZero};
        return answer;
    }
    public static void Transform(String s){
        if(s.length() == 1) 
            return;
        
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '0') countZero++;
        }
        s = s.replaceAll("0", "");
        Transform(Integer.toString(s.length(), 2));
        countTrans++;
    }
}