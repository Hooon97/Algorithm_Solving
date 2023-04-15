import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i<s.length(); i++){
            StringBuilder sb = new StringBuilder();
            for(int j = i; j<i+s.length(); j++){
                sb.append(s.charAt(j%s.length()));
            }

            if(isCorrect(sb.toString())) 
                answer++;
        }
        
        return answer;
    }
    private boolean isCorrect(String s){
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
            }
            else{
                if(st.peek() == '(' && s.charAt(i) == ')'){
                    st.pop();
                }
                else if(st.peek() == '{' && s.charAt(i) == '}'){
                    st.pop();
                }
                else if(st.peek() == '[' && s.charAt(i) == ']'){
                    st.pop();
                }
                else if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                    st.push(s.charAt(i));
                }
                else return false;
            }
        }
        if(st.isEmpty()) return true;
        else return false;
    }
}