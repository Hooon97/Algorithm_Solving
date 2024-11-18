import java.util.*;
class Solution {
    int[][] answer;
    int idx;
    public int[][] solution(int n) {
        answer = new int[(int)(Math.pow(2,n)-1)][2];
        idx = 0;
        
        hanoi(n,1,3);    
        return answer;
    }
    public void hanoi(int n, int from, int to){
        if(n == 1){
            answer[idx][0] = from;
            answer[idx][1] = to;
            idx++;
            return;
        }
        
        int next = 6-(from+to);
        
        hanoi(n-1, from, next);
        hanoi(1, from, to);
        hanoi(n-1, next, to);
    }
}