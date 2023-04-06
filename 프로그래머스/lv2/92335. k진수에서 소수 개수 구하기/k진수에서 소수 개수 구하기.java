import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String number = Integer.toString(n, k);
        String[] s_number = number.split("0");
        for(String s : s_number){
            if(s.equals("")) continue;
            if(isPrime(Long.valueOf(s))) answer++;
        }
        
        return answer;
        
}
    public static boolean isPrime(long s){
        if(s == 1) return false;
        for(int i = 2; i<=(int)Math.sqrt(s); i++){
            if(s%i == 0) return false;
        }
        return true;
    }
}