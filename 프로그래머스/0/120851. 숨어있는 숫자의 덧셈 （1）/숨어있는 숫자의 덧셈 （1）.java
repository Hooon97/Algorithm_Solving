import java.util.*;
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(char c : my_string.toCharArray())
            answer = Character.isDigit(c) ? answer + c-'0' :answer + 0;
        return answer;
    }
}