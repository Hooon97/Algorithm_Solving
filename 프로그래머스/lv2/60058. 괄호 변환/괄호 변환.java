import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = Recur(p);
        return answer;
    }
    String Recur(String p){
        if(p.equals("")) return "";
        int idx = getBalancedIndex(p);
        String u = p.substring(0,idx+1);
        String v = p.substring(idx+1, p.length());
        
        if(isCorrect(u)){
            return u+Recur(v);
        }
        else{
            return "(" + Recur(v) + ")" + correctString(u);
        }
    }
    public int getBalancedIndex(String p){
        int left = 0;
        int right = 0;
        int idx = p.length()-1;
        for(int i = 0; i<p.length(); i++){
            if(p.charAt(i) == '(') left++;
            else right++;
            if(left != 0 && right != 0 && left == right){
                idx = i;
                break;
            }
        }
        return idx;
    }
    public boolean isCorrect(String u){
        int count = 0;
        for(int i = 0; i < u.length(); i++){
            if(u.charAt(i) == '(') count++;
            else count--;
            if(count < 0) return false;
        }
        return true;
    }
    public String correctString(String u){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<u.length()-1; i++){
            if(u.charAt(i) == '(') sb.append(')');
            else sb.append('(');
        }
        return sb.toString();
    }
}