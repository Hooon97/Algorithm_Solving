import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int min = 100;
        int length = score.length;
        for(int i = length-1; i>=0; i--){
            min = Math.min(min, score[i]);
            if((length-i) % m == 0){
                answer += min * m;
                min = 100;
            }
        }
        
        return answer;
    }
}