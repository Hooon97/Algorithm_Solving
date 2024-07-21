import java.util.*;

class Solution {
    int[] answer;
    public int[] solution(int n, int[] info) {
        answer = new int[]{-1};
        boolean[] visit = new boolean[11];
        int[] lion = new int[n];
        perm(info, lion, 0, visit);
        
        return answer;
    }
    int maxDiff;
    public void perm(int[] peach, int[] lion, int depth, boolean[] visit){
        if(depth == lion.length){
            int score = getScore(peach, lion);
            if(score > 0 && score >= maxDiff){
                maxDiff = score;
                answer = getAnswer(peach, lion);
            }
            return;
        }
        
        for(int i = 0; i<11; i++){
            if(visit[i]) continue;
            visit[i] = true;
            lion[depth] = i;
            perm(peach, lion, depth+1, visit);
            visit[i] = false;
        }
    }
    
    public int[] getAnswer(int[] peach, int[] lion){
        int[] copyPeach = peach.clone();
        int[] copyLion = lion.clone();
        int cnt = lion.length;
        int[] answerArr = new int[11];
        
        for(int num : lion){
            if(copyPeach[num] < cnt){
                cnt -= copyPeach[num]+1;
                answerArr[num] = copyPeach[num]+1;
                copyPeach[num] = -1;
            }
        }
        
        if(cnt > 0){
            answerArr[10] += cnt;
        }
        
        return answerArr;
    }
    
    public int getScore(int[] peach, int[] lion){
        int[] copyPeach = peach.clone();
        int[] copyLion = lion.clone();
        int cnt = lion.length;
        
        for(int num : lion){
            if(copyPeach[num] < cnt){
                cnt -= copyPeach[num]+1;
                copyPeach[num] = -1;
            }
        }
        
        int score = 0;
        for(int i = 0; i<11; i++){
            if(copyPeach[i] > 0) score -= (10-i);
            else if(copyPeach[i] < 0) score += (10-i);
        }
        
        return score;
    }
}