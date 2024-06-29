import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        /*
            1. 제외 사원을 제외한다.
            2. 합으로 정렬해서 순위를 구한다.
        */
        int answer = 1;
        int maxScore = 0;
        int[] wanho = scores[0];
        
        for(int i = 1; i<scores.length; i++){
            if(wanho[0] < scores[i][0] && wanho[1] < scores[i][1]) return -1;
        }
        
        Arrays.sort(scores, (o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
        });
        
        for(int[] score : scores){
            if(maxScore <= score[1]){
                maxScore = score[1];
                if(score[0] + score[1] > wanho[0] + wanho[1]) answer++;
            }
            else {
                if(score == wanho) return -1;
            }
        }
        
        
        return answer;
    }
}