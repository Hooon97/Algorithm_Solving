import java.util.*;
class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder num = new StringBuilder();
        String[] numbs = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i<s.length(); i++){
            if(0<= s.charAt(i) - '0' && s.charAt(i) - '0' < 10){
                //숫자임
                sb.append(s.charAt(i));
                continue;
            }
            //문자
            num.append(s.charAt(i));
            for(int j = 0; j<10; j++){
                if(num.toString().equals(numbs[j])){
                    sb.append(j);
                    num.setLength(0);
                    break;
                }
            }
        }
        
        int answer = Integer.valueOf(sb.toString());
        return answer;
    }
}