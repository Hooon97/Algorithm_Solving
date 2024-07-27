class Solution {
    public String solution(String s) {
        if(s.length() % 2 == 1){
            return String.valueOf(s.charAt(s.length()/2));
        } else{
            return String.valueOf(s.charAt(s.length()/2-1)+""+s.charAt(s.length()/2));
        }
    }
}