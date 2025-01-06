import java.util.*;
class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        Set<String> chk = new HashSet<>(Arrays.asList(s1));
        for(String s : s2) if(chk.contains(s)) answer++;
        return answer;
    }
}