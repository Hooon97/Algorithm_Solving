import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {-1};
        if(n > s) return answer;
        answer = new int[n];
        for(int i = 0; i<n; i++)
            answer[i] = s/n;
        for(int i = 0; i<s%n; i++){
            answer[n-1-i]++;
        }
        
        return answer;
    }
}